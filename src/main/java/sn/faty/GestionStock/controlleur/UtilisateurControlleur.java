package sn.faty.gestionstock.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.faty.gestionstock.controlleur.Interfaces.UtilisateurApi;
import sn.faty.gestionstock.dto.UtilisateurDTO;
import sn.faty.gestionstock.service.Interface.UtilisateurService;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")

@RestController
@RequestMapping
public class UtilisateurControlleur implements UtilisateurApi {

    private UtilisateurService utilisateurService ;
   @Autowired
    public UtilisateurControlleur(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public ResponseEntity<UtilisateurDTO> saveUtilisateur(UtilisateurDTO utilisateurDTO) {
        return ResponseEntity.ok().body(utilisateurService.saveUtilisateur(utilisateurDTO));
    }
    @Override
    public ResponseEntity<List<UtilisateurDTO>> findAll() {
        return ResponseEntity.ok().body(utilisateurService.findAll());
    }

    @Override
    public void deleteById(Long id) {
       utilisateurService.deleteById(id);
    }
    @Override
    public ResponseEntity<UtilisateurDTO> findById(Long id) {
        return  ResponseEntity.ok().body(utilisateurService.findById(id));
    }

    @Override
    public ResponseEntity<UtilisateurDTO> findByNom(String nom) {
        return ResponseEntity.ok().body(utilisateurService.findByNom(nom));
    }
}
