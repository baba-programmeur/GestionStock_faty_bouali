package sn.faty.gestionstock.controlleur.Interfaces;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.faty.gestionstock.dto.CommandeFournisseurDTO;

import java.util.List;

import static sn.faty.gestionstock.constants.Constants.APP_ROOT;

public interface CommandeFournisseurAPI {


    @PostMapping(value = APP_ROOT+"/addFournisseurCommande",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeFournisseurDTO> saveFournisseurCommand(@RequestBody CommandeFournisseurDTO commandeFournisseurDTO);

    @GetMapping(value = APP_ROOT+ "/GetAllCommandFournisseur",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity <List<CommandeFournisseurDTO>> findAll();

    @DeleteMapping(value=APP_ROOT+ "/deleteFournisseurCommand/{id}")
    void deleteById(@PathVariable Long id);


    @GetMapping(value = APP_ROOT+"/searchFournisseurCommand/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeFournisseurDTO> findById(@PathVariable  Long id);

    @GetMapping(value = APP_ROOT+"/searchFournisseurCommand/{nom}",produces = MediaType.APPLICATION_JSON_VALUE)

    ResponseEntity<CommandeFournisseurDTO> findByNom(@PathVariable  String nom);


    ResponseEntity<CommandeFournisseurDTO> findByCode(String code);

}
