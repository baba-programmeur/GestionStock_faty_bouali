package sn.faty.gestionstock.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.faty.gestionstock.controlleur.Interfaces.EntrepriseApi;
import sn.faty.gestionstock.dto.EntrepriseDTO;
import sn.faty.gestionstock.service.Interface.EntrepriseService;

import java.util.List;
@RestController
public class EntrepriseController implements EntrepriseApi {

    private EntrepriseService entrepriseService ;

   @Autowired
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @Override
    public EntrepriseDTO saveEntreprise(EntrepriseDTO entrepriseDTO) {
        return entrepriseService.saveEntreprise(entrepriseDTO);
    }

    @Override
    public List<EntrepriseDTO> findAll() {
        return  entrepriseService.findAll();
    }

    @Override
    public void deleteById(Long id) {
         entrepriseService.deleteById(id);
    }

    @Override
    public EntrepriseDTO findById(Long id) {
        return entrepriseService.findById(id);
    }

    @Override
    public EntrepriseDTO findByNom(String nom) {
        return entrepriseService.findByNom(nom);
    }
}
