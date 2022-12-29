package sn.faty.gestionstock.service.implementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.gestionstock.Repository.CommandeFournisseurRepository;
import sn.faty.gestionstock.Repository.FournisseurRepository;
import sn.faty.gestionstock.Validators.FournisseurValidator;
import sn.faty.gestionstock.dto.FournisseurDTO;
import sn.faty.gestionstock.exception.EntittyNotFoundException;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.exception.InvalidOperationException;
import sn.faty.gestionstock.model.CommandeFournisseur;
import sn.faty.gestionstock.service.Interface.FournisseurService;
import sn.faty.gestionstock.service.mappeur.FournisseurMappeur;
import sn.faty.gestionstock.service.mappeur.FournisseurMappeurImpl;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurImpl implements FournisseurService {

       private FournisseurRepository fournisseurRepository ;

       //If we have Service we dont need @Autowires in the implementation class
       private  FournisseurMappeur fournisseurMappeur=new FournisseurMappeurImpl();

       private CommandeFournisseurRepository commandeFournisseurRepository ;

    @Autowired
    public FournisseurImpl(FournisseurRepository fournisseurRepository,CommandeFournisseurRepository commandeFournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
        this.commandeFournisseurRepository=commandeFournisseurRepository ;
    }
    @Override
    public FournisseurDTO saveFournisseur(FournisseurDTO fournisseurDTO) {

       List<String> errors= FournisseurValidator.validerFournisseur(fournisseurDTO);

        if(! errors.isEmpty())
        {
            log.debug("Article is not valid {} :",fournisseurDTO);
            throw new InvalidException("Fournisseur is not valid", ErrorCodes.FOURNISSEUR_NOT_VALID,errors);
        }
        //   Article article= articleRepository.save(ArticleMappeurImpl.toEntity(articleDTO));
        return  fournisseurMappeur.toDto(fournisseurRepository.save(fournisseurMappeur.toEntity(fournisseurDTO)));

    }
    @Override
    public List<FournisseurDTO> findAll() {
        return fournisseurRepository.findAll().stream()
                .map(fournisseurMappeur::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
          if(id==null)
          {
              log.debug("Your id is null");
          }

        List<CommandeFournisseur> commandeFournisseurs= commandeFournisseurRepository.findAllByFournisseurId(id);

        if(! commandeFournisseurs.isEmpty())
        {
            throw  new InvalidOperationException("Impossible de supprimer un client engage dans une commande",ErrorCodes.COMMANDE_QUI_A_DEJA_COMMANDE);
        }
        else {
            fournisseurRepository.deleteById(id);
        }
    }

    @Override
    public FournisseurDTO findById(Long id) {
        if(id==null)
        {
            log.debug("Your id is null");
        }

        return fournisseurMappeur.toDto(fournisseurRepository.findById(id)
                .orElseThrow(()->new EntittyNotFoundException("This fournisseur is not in the database")));
    }
    @Override
    public FournisseurDTO findByNom(String nom) {
        if(!StringUtils.hasText(nom))
        {
            log.debug("Veuiller donner un nom à rechercher");
            throw  new InvalidException("Veuiller donner un nom à rechercher");
        }
        return fournisseurMappeur.toDto(fournisseurRepository.findFournisseurByNom(nom))  ;

    }
}
