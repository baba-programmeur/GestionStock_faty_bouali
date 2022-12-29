package sn.faty.gestionstock.controlleur.Interfaces;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.faty.gestionstock.dto.FournisseurDTO;

import java.util.List;

import static sn.faty.gestionstock.constants.Constants.APP_ROOT;

public interface FournisseurAPI {

    @PostMapping(value = APP_ROOT+"/addVendor",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FournisseurDTO> saveFournisseur(@RequestBody FournisseurDTO fournisseurDTO);

    @GetMapping(value = APP_ROOT+ "/getAllVendors",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<FournisseurDTO>> findAll();

    @DeleteMapping(value=APP_ROOT+ "/deleteVendor/{id}")
    void deleteById(@PathVariable Long id);


    @GetMapping(value = APP_ROOT+"/searchVendor/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FournisseurDTO> findById(@PathVariable  Long id);

    @GetMapping(value = APP_ROOT+"/searchVendors/{nom}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FournisseurDTO> findByNom(@PathVariable  String nom);
}
