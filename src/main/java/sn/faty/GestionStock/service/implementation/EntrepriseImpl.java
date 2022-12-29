package sn.faty.gestionstock.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.gestionstock.Repository.EntrepriseRepository;
import sn.faty.gestionstock.Repository.RoleRepository;
import sn.faty.gestionstock.Validators.EntrepriseValidator;
import sn.faty.gestionstock.dto.EntrepriseDTO;
import sn.faty.gestionstock.dto.RolesDTO;
import sn.faty.gestionstock.dto.UtilisateurDTO;
import sn.faty.gestionstock.exception.EntittyNotFoundException;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.service.Interface.EntrepriseService;
import sn.faty.gestionstock.service.Interface.UtilisateurService;
import sn.faty.gestionstock.service.mappeur.EntrepriseMappeurImpl;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository ;
    private UtilisateurService utilisateurService ;
    private RoleRepository roleRepository ;
  @Autowired
    public EntrepriseImpl(EntrepriseRepository entrepriseRepository,UtilisateurService utilisateurService,RoleRepository roleRepository) {
        this.entrepriseRepository = entrepriseRepository;
        this.utilisateurService=utilisateurService ;
        this.roleRepository=roleRepository ;
    }

    @Override
    public EntrepriseDTO saveEntreprise(EntrepriseDTO entrepriseDTO) {

//        List<String> errors= EntrepriseValidator.validerEntreprise(entrepriseDTO);
//
//        if(!errors.isEmpty())
//        {
//            log.debug("Article is not valid {} :",entrepriseDTO);
//
//            throw new InvalidException("Fournisseur is not valid", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID,errors);
//        }

        EntrepriseDTO savedEntreprise= EntrepriseMappeurImpl.toDto(entrepriseRepository.save(EntrepriseMappeurImpl.toEntity(entrepriseDTO)));

        UtilisateurDTO utilisateur = fromEntreprise(savedEntreprise);

        UtilisateurDTO savedUser = utilisateurService.saveUtilisateur(utilisateur);

        RolesDTO rolesDto = RolesDTO.builder()
                .roleName("ADMIN")
                .utilisateur(savedUser)

                .build();

        roleRepository.save(RolesDTO.toEntity(rolesDto));

        return  savedEntreprise;

    }
//mappage dune entreprise avec lentite utilisateurDto
    private UtilisateurDTO fromEntreprise(EntrepriseDTO entrepriseDTO) {
        return UtilisateurDTO.builder()
                //.adresse(entreprise.getAdresse())
                .nom(entrepriseDTO.getNom())
                .email(entrepriseDTO.getEmail())
                .motDePasse(generateRandomPassword())
                .entreprise(entrepriseDTO)
                .dateNaissance(Instant.now())
                .photo(entrepriseDTO.getPhoto())
                .build();
    }
    private String generateRandomPassword() {
        return "som3R@nd0mP@$$word";
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
