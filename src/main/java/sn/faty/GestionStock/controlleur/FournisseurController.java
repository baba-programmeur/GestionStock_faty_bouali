package sn.faty.gestionstock.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.faty.gestionstock.controlleur.Interfaces.FournisseurAPI;
import sn.faty.gestionstock.dto.FournisseurDTO;
import sn.faty.gestionstock.service.Interface.FournisseurService;

import java.util.List;
@RestController
@RequestMapping
public class FournisseurController implements FournisseurAPI {

    private  FournisseurService fournisseurService ;

    @Autowired
    public FournisseurController(FournisseurService fournisseurService){
        this.fournisseurService=fournisseurService;
    }
    @Override
    public ResponseEntity<FournisseurDTO> saveFournisseur(FournisseurDTO fournisseurDTO) {
        return ResponseEntity.ok(fournisseurService.saveFournisseur(fournisseurDTO));
    }

    @Override
    public ResponseEntity<List<FournisseurDTO>> findAll() {
        return ResponseEntity.ok(fournisseurService.findAll());
    }

    @Override
    public void deleteById(Long id) {
        fournisseurService.deleteById(id);
    }

    @Override
    public ResponseEntity<FournisseurDTO> findById(Long id) {
        return ResponseEntity.ok(fournisseurService.findById(id));
    }

    @Override
    public ResponseEntity<FournisseurDTO> findByNom(String nom) {
        return ResponseEntity.ok(fournisseurService.findByNom(nom));
    }
}
