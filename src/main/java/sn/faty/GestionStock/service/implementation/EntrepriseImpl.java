package sn.faty.GestionStock.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.GestionStock.Repository.EntrepriseRepository;
import sn.faty.GestionStock.Validators.EntrepriseValidator;
import sn.faty.GestionStock.dto.EntrepriseDTO;
import sn.faty.GestionStock.exception.EntittyNotFoundException;
import sn.faty.GestionStock.exception.ErrorCodes;
import sn.faty.GestionStock.exception.InvalidException;
import sn.faty.GestionStock.service.Interface.EntrepriseService;
import sn.faty.GestionStock.service.mappeur.EntrepriseMappeurImpl;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository ;
  @Autowired
    public EntrepriseImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public EntrepriseDTO saveEntreprise(EntrepriseDTO entrepriseDTO) {

        List<String> errors= EntrepriseValidator.validerEntreprise(entrepriseDTO);

        if(!errors.isEmpty())
        {
            log.debug("Article is not valid {} :",entrepriseDTO);

            throw new InvalidException("Fournisseur is not valid", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID,errors);
        }
        return EntrepriseMappeurImpl.toDto(entrepriseRepository.save(EntrepriseMappeurImpl.toEntity(entrepriseDTO)));

    }

    @Override
    public List<EntrepriseDTO> findAll() {
        return entrepriseRepository.findAll().stream().map(EntrepriseMappeurImpl::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if(id==null)
        {
            log.debug("Your id is null");
        }
        entrepriseRepository.deleteById(id);

    }

    @Override
    public EntrepriseDTO findById(Long id) {
        if(id==null)
        {
            log.debug("Your id is null");
        }

        return EntrepriseMappeurImpl.toDto(entrepriseRepository.findById(id)
                .orElseThrow(()->new EntittyNotFoundException("This Entreprise  is not in the database")));
    }
    @Override
    public EntrepriseDTO findByNom(String nom) {
        if(!StringUtils.hasText(nom))
        {
            log.debug("Veuiller donner un nom à rechercher");
            throw  new InvalidException("Veuiller donner un nom à rechercher");
        }
        return EntrepriseMappeurImpl.toDto(entrepriseRepository.findEntrepriseByNom(nom))  ;

    }
}
