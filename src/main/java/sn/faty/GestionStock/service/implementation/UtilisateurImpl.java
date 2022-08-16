package sn.faty.GestionStock.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.GestionStock.Repository.UtilisateurRepository;
import sn.faty.GestionStock.Validators.UtilisateurValidator;
import sn.faty.GestionStock.dto.UtilisateurDTO;
import sn.faty.GestionStock.exception.EntittyNotFoundException;
import sn.faty.GestionStock.exception.ErrorCodes;
import sn.faty.GestionStock.exception.InvalidException;
import sn.faty.GestionStock.service.Interface.UtilisateurService;
import sn.faty.GestionStock.service.mappeur.UtilisateurMappeur;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurImpl implements UtilisateurService {

    private  UtilisateurService utilisateurService ;
    private UtilisateurRepository utilisateurRepository ;
    private UtilisateurMappeur utilisateurMappeur ;

@Autowired
    public UtilisateurImpl(UtilisateurRepository utilisateurRepository,UtilisateurMappeur utilisateurMappeur) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMappeur = utilisateurMappeur;
    }

    @Override
    public UtilisateurDTO saveUtilisateur(UtilisateurDTO utilisateurDTO) {

        List<String> errors= UtilisateurValidator.validerUtilisateur(utilisateurDTO);

        if(!errors.isEmpty())
        {
            log.debug("User is not valid {} :",utilisateurDTO);

            throw new InvalidException("User is not valid", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID,errors);
        }
        //   Article article= articleRepository.save(ArticleMappeurImpl.toEntity(articleDTO));
        return  utilisateurMappeur.toDto(utilisateurRepository.save(utilisateurMappeur.toEntity(utilisateurDTO)));

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
                .orElseThrow(()->new EntittyNotFoundException("This Userb is not in the database")));
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
}
