package sn.faty.gestionstock.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.gestionstock.Repository.UtilisateurRepository;
import sn.faty.gestionstock.Validators.UtilisateurValidator;
import sn.faty.gestionstock.dto.ChangerMotDePasseDTO;
import sn.faty.gestionstock.dto.UtilisateurDTO;
import sn.faty.gestionstock.exception.EntittyNotFoundException;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.exception.InvalidOperationException;
import sn.faty.gestionstock.model.Utilisateur;
import sn.faty.gestionstock.service.Interface.UtilisateurService;
import sn.faty.gestionstock.service.mappeur.UtilisateurMappeur;
import sn.faty.gestionstock.service.mappeur.UtilisateurMappeurImpl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository ;
  //  private PasswordEncoder passwordEncoder ;
    private UtilisateurMappeur utilisateurMappeur =new UtilisateurMappeurImpl();

   // private ArticleRepository articleRepository ;

@Autowired
    public UtilisateurImpl(UtilisateurRepository utilisateurRepository /*PasswordEncoder passwordEncoder*/) {
        this.utilisateurRepository = utilisateurRepository;
       // this.passwordEncoder=passwordEncoder ;
    }

    @Override
    public UtilisateurDTO saveUtilisateur(UtilisateurDTO utilisateurDTO) {

        List<String> errors= UtilisateurValidator.validerUtilisateur(utilisateurDTO);

        if(! errors.isEmpty())
        {
            log.debug("User is not valid {} :",utilisateurDTO);

            throw new InvalidException("User is not valid", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID,errors);
        }
          //  Article article= articleRepository.save(ArticleMappeurImpl.toEntity(articleDTO));

        //regardons si lutilisateur existe dabord dans la base

        if(isUserAlreadyExist(utilisateurDTO.getEmail())){

            throw new InvalidOperationException("Cet utilisateur existe deja dans la base",ErrorCodes.UTILISATEUR_ALREADY_EXIST);
        }

       Optional <Utilisateur> user=  utilisateurRepository.findUtilisateurByEmail(utilisateurDTO.getEmail());

           if(user.isPresent()){
               throw  new InvalidOperationException("Cet utilisateur existe deja dans la bas",ErrorCodes.UTILISATEUR_ALREADY_EXIST);
           }

     //   utilisateurDTO.setMotDePasse(passwordEncoder.encode(utilisateurDTO.getMotDePasse()));

        return  utilisateurMappeur.toDto(utilisateurRepository.save(utilisateurMappeur.toEntity(utilisateurDTO)));

    }


    private  boolean isUserAlreadyExist(String email){

    Optional<Utilisateur> utilisateur= utilisateurRepository.findUtilisateurByEmail(email);

    return utilisateur.isPresent();
    }

    @Override
    public List<UtilisateurDTO> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(utilisateurMappeur::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if(id==null)
        {
            log.debug("Your id is null");
        }
        utilisateurRepository.deleteById(id);
    }

    @Override
    public UtilisateurDTO findById(Long id) {
        if(id==null)
        {
            log.debug("Your id is null");
        }

        return utilisateurMappeur.toDto(utilisateurRepository.findById(id)
                .orElseThrow(()->new EntittyNotFoundException("This User is not in the database")));
    }

    @Override
    public UtilisateurDTO findByNom(String nom) {
        if(!StringUtils.hasText(nom))
        {
            log.debug("Veuiller donner un nom à rechercher");
            throw  new InvalidException("Veuiller donner un nom à rechercher");
        }
        return utilisateurMappeur.toDto(utilisateurRepository.findUtilisateurByNom(nom))  ;

    }
    @Override
    public  UtilisateurDTO findByEmail(String username) {

  return  utilisateurRepository.findUtilisateurByEmail(username).map(utilisateurMappeur::toDto).
          orElseThrow(()-> new EntittyNotFoundException("lutilisater avec lemail"+username+"nexiste pas",ErrorCodes.UTILISATEUR_NOT_FOUND));
    }

    @Override
    public UtilisateurDTO changerMotDePasse(ChangerMotDePasseDTO changerMotDePasseDTO) {

      this.validerChangementMotDePasse(changerMotDePasseDTO);

      Optional<Utilisateur> utilisateur=utilisateurRepository.findById(changerMotDePasseDTO.getIdUser());
        if(utilisateur.isEmpty()){
            throw  new InvalidException("Impossible de changer un mot de passe dont lutilisateur nexiste pas",ErrorCodes.UTILISATEUR_NOT_FOUND);
        }

        Utilisateur utilisateurTrouve=utilisateur.get();

        utilisateurTrouve.setMotDePasse(changerMotDePasseDTO.getMotDePasse());

       return    utilisateurMappeur.toDto(utilisateurRepository.save(utilisateurTrouve))      ;

    }

    private void validerChangementMotDePasse(ChangerMotDePasseDTO changerMotDePasseDTO){

      if(changerMotDePasseDTO.getIdUser()==null){
          log.debug("Impossible de changer un mot de passe avec un  ID null");
          throw  new InvalidException("Impossible de changer un mot de passe avec un  ID null"+ changerMotDePasseDTO.getIdUser());
      }
      if(changerMotDePasseDTO==null)
      {
          log.debug("Impossible de changer un mot de passe avec un objet null");

          throw new InvalidException("Impossible de changer le mot de passe avec des informations vides",ErrorCodes.UTILISATEUR);
      }

      if(! changerMotDePasseDTO.getMotDePasse().toLowerCase().equals(changerMotDePasseDTO.getConfirmationMotDePasse().toLowerCase())){

          log.debug("Impossible de changer le mot de passe avec deux mots de passe differents");

          throw new InvalidException("Impossible de changer le mot de passe avec deux mots de passe differents",ErrorCodes.MOT_DE_PASSE_UTILISATEUR_ET_CONFIRMATION_NON_CONFORME);
      }
      if(! StringUtils.hasLength(changerMotDePasseDTO.getConfirmationMotDePasse()) || StringUtils.hasLength(changerMotDePasseDTO.getMotDePasse()) ){

          log.debug("Impossible de changer le mot de passe dans ces conditions");

          throw new InvalidException("Impossible de changer le mot de passe dans ces conditions ",ErrorCodes.MOT_DE_PASSE_UTILISATEUR_OU_ET_CONFIRMATION_NON_CONFORME);
      }

    }
}
