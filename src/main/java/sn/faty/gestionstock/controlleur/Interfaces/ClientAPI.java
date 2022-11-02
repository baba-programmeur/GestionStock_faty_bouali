package sn.faty.gestionstock.controlleur.Interfaces;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sn.faty.gestionstock.dto.ClientDTO;
import java.util.List;


import static sn.faty.gestionstock.constants.Constants.APP_ROOT;

public interface ClientAPI {

    @PostMapping(value = APP_ROOT+"/addCustomer",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDTO saveClient(@RequestBody ClientDTO clientDTO);

    @GetMapping(value = APP_ROOT+ "/getAllCustomers",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDTO> findAll();

    @DeleteMapping(value=APP_ROOT+ "/deleteCustomer/{id}")
    void deleteById(@PathVariable Long id);


    @GetMapping(value = APP_ROOT+"/searchCustomer/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDTO findById(@PathVariable  Long id);

    @GetMapping(value = APP_ROOT+"/searchCutomers/{nom}",produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDTO findByNom(@PathVariable  String nom);
}
