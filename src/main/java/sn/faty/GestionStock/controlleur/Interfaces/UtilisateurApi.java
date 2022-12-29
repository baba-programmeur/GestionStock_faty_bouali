package sn.faty.gestionstock.controlleur.Interfaces;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.faty.gestionstock.dto.UtilisateurDTO;

import java.util.List;

import static sn.faty.gestionstock.constants.Constants.APP_ROOT;

public interface UtilisateurApi {

    @PostMapping(value = APP_ROOT+"/addUser",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UtilisateurDTO> saveUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO);

    @GetMapping(value = APP_ROOT+ "/getAllUsers",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UtilisateurDTO>> findAll();

    @DeleteMapping(value=APP_ROOT+ "/deleteUser/{id}")
    void deleteById(@PathVariable Long id);

    @GetMapping(value = APP_ROOT+"/searchUser/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UtilisateurDTO> findById(@PathVariable("id")  Long id);

    @GetMapping(value = APP_ROOT+"/searchUsers/{nom}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UtilisateurDTO> findByNom(@PathVariable  String nom);


}
