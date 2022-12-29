package sn.faty.gestionstock.controlleur.Interfaces;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.faty.gestionstock.dto.VenteDTO;

import java.util.List;

import static sn.faty.gestionstock.constants.Constants.APP_ROOT;

public interface VenteApi {

    @PostMapping(value = APP_ROOT+"/addVente",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VenteDTO> saveVente(@RequestBody VenteDTO venteDTO);

    @GetMapping(value = APP_ROOT+ "/getAllVentes",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<VenteDTO>> findAll();

    @DeleteMapping(value=APP_ROOT+ "/deleteVente/{id}")
    void deleteById(@PathVariable Long id);


    @GetMapping(value = APP_ROOT+"/searchVente/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VenteDTO> findById(@PathVariable("id")  Long id);

    @GetMapping(value = APP_ROOT+"/searchVente/{nom}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VenteDTO> findByCode(@PathVariable("nom")  String code);

}
