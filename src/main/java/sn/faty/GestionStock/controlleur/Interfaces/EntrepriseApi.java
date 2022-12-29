package sn.faty.gestionstock.controlleur.Interfaces;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sn.faty.gestionstock.dto.EntrepriseDTO;

import java.util.List;

import static sn.faty.gestionstock.constants.Constants.APP_ROOT;

public interface EntrepriseApi {

    @PostMapping(value = APP_ROOT+"/addEntreprise",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDTO saveEntreprise(@RequestBody EntrepriseDTO entrepriseDTO);

    @GetMapping(value = APP_ROOT+ "/GetAllEntreprise",produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDTO> findAll();

    @DeleteMapping(value=APP_ROOT+ "/deleteEntreprise/{id}")
    void deleteById(@PathVariable Long id);

    @GetMapping(value = APP_ROOT+"/searchEntreprise/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDTO findById(@PathVariable  Long id);

    @GetMapping(value = APP_ROOT+"/searchEntreprise/{nom}",produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDTO findByNom(@PathVariable  String nom);

}
