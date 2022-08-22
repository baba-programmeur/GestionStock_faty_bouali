package sn.faty.GestionStock.controlleur.Interfaces;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sn.faty.GestionStock.dto.ClientDTO;
import java.util.List;


import static sn.faty.GestionStock.constants.Constants.APP_ROOT;

public interface ClientAPI {

    @PostMapping(value = APP_ROOT+"/addCustomer",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDTO saveClient(@RequestBody ClientDTO clientDTO);

    @GetMapping(value = APP_ROOT+ "/GetAllCustomers",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDTO> findAll();

    @DeleteMapping(value=APP_ROOT+ "/deleteCutomer/{id}")
    void deleteById(@PathVariable Long id);


    @GetMapping(value = APP_ROOT+"/searchArticle/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDTO findById(@PathVariable  Long id);

    @GetMapping(value = APP_ROOT+"/searchCutomer/{nom}",produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDTO findByNom(@PathVariable  String nom);
}
