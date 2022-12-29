package sn.faty.gestionstock.controlleur.Interfaces;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.faty.gestionstock.dto.CommandeClientDTO;
import sn.faty.gestionstock.dto.LigneCommandeClientDTO;
import sn.faty.gestionstock.model.EtatCommande;
import java.math.BigDecimal;
import java.util.List;
import static sn.faty.gestionstock.constants.Constants.APP_ROOT;
public interface CommandeClientApi {

    @PostMapping(value = APP_ROOT+"/addCustomerOrder",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
   ResponseEntity <CommandeClientDTO> saveCustomerCommande(@RequestBody CommandeClientDTO commandeClientDTO);

    @GetMapping(value = APP_ROOT+ "/getAllOrders",produces = MediaType.APPLICATION_JSON_VALUE)
      ResponseEntity <List<CommandeClientDTO>> findAll();

    @DeleteMapping(value=APP_ROOT+ "/deleteCustomerOrder/{id}")
   void deleteById(@PathVariable Long id);

    @PutMapping(value = APP_ROOT+ "/updateEtat/{idCommande}/{etatCommande}")

   ResponseEntity <CommandeClientDTO> updateEtatCommande(@PathVariable("idCommande") Long idCommande, @PathVariable("etatCommande") EtatCommande etatCommande);

    @PutMapping(value = APP_ROOT+"/updateQuantiteCommande/{idCommande}/{idLigneCommande}/{newQuantite}")

  ResponseEntity <CommandeClientDTO> updateQuantiteCommande(@PathVariable("idCommande") Long idCommande, @PathVariable("idLigneCommande") Long idLigneCommande,@PathVariable("newQuantite") BigDecimal newQuantitite);

    @PutMapping(value = APP_ROOT+"/updateClient/{idClient}/{idCommande}")

    ResponseEntity <CommandeClientDTO> updateClient(@PathVariable("idClient") Long idClient, @PathVariable("idCommande") Long idCommande);


    @PutMapping(value = APP_ROOT+"/updateArticle/{idArticle}/{idLigneCommandeClient}/{idCommandeClient}")

    ResponseEntity <CommandeClientDTO> updateArticle(@PathVariable("idArticle") Long idArticle, @PathVariable("idLigneCommandeClient") Long idLigneCommandeClient,@PathVariable("idCommandeClient") Long idCommandeClient);

    @GetMapping(value = APP_ROOT+"/searchCustomerOrder/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeClientDTO> findById(@PathVariable  Long id);

    @GetMapping(value = APP_ROOT+"/searchCustomersOrders/{nom}",produces = MediaType.APPLICATION_JSON_VALUE)

    ResponseEntity<CommandeClientDTO> findByNom(@PathVariable  String nom);

@DeleteMapping(value = APP_ROOT+ "/deleteArticle/{idLigneCommandeClient}/{idCommandeClient}")

 void deleteArticle(@PathVariable("idLigneCommandeClient") Long idLigneCommandeClient,@PathVariable("idCommandeClient") Long idCommandeClient);

    ResponseEntity<CommandeClientDTO> findByCode(String code);

    @GetMapping(value = APP_ROOT+"/searchAllOrdersDetails/{id}",produces = MediaType.APPLICATION_JSON_VALUE)

    ResponseEntity <List<LigneCommandeClientDTO>> findAllLigneCommandeParIdClient(@PathVariable Long id);
}
