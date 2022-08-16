package sn.faty.GestionStock.service.implementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.GestionStock.Repository.FournisseurRepository;
import sn.faty.GestionStock.Validators.FournisseurValidator;
import sn.faty.GestionStock.dto.FournisseurDTO;
import sn.faty.GestionStock.exception.EntittyNotFoundException;
import sn.faty.GestionStock.exception.ErrorCodes;
import sn.faty.GestionStock.exception.InvalidException;
import sn.faty.GestionStock.service.Interface.FournisseurService;
import sn.faty.GestionStock.service.mappeur.FournisseurMappeur;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurImpl implements FournisseurService {

       private FournisseurRepository fournisseurRepository ;

       //If we have Service we dont need @Autowires in the implementation class
       private  FournisseurMappeur fournisseurMappeur;

    @Autowired
    public FournisseurImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }
    @Override
    public FournisseurDTO saveFournisseur(FournisseurDTO fournisseurDTO) {

        List<String> errors= FournisseurValidator.validerFournisseur(fournisseurDTO);

        if(!errors.isEmpty())
        {
            log.debug("Article is not valid {} :",fournisseurDTO);

            throw new InvalidException("Fournisseur is not valid", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID,errors);
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
          fournisseurRepository.deleteById(id);
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
