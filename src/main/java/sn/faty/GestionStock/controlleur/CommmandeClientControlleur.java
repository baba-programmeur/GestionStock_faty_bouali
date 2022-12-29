package sn.faty.gestionstock.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.faty.gestionstock.controlleur.Interfaces.CommandeClientApi;
import sn.faty.gestionstock.dto.CommandeClientDTO;
import sn.faty.gestionstock.dto.LigneCommandeClientDTO;
import sn.faty.gestionstock.model.EtatCommande;
import sn.faty.gestionstock.service.Interface.CommandeClientService;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping
public class CommmandeClientControlleur implements CommandeClientApi {

    private CommandeClientService commandeClientService;

     @Autowired
    public CommmandeClientControlleur(CommandeClientService commandeClientService) {
        this.commandeClientService = commandeClientService;
    }

    @Override
    public ResponseEntity<CommandeClientDTO> saveCustomerCommande(CommandeClientDTO commandeClientDTO) {
        return  ResponseEntity.ok(commandeClientService.savecommmandeclient(commandeClientDTO));
    }

    @Override
    public ResponseEntity<List<CommandeClientDTO>> findAll() {
        return  ResponseEntity.ok(commandeClientService.findAll());
    }
    @Override
    public void  deleteById(Long id) {

        commandeClientService.deleteById(id);
    }

    @Override
    public ResponseEntity<CommandeClientDTO> updateEtatCommande(Long idCommande, EtatCommande etatCommande) {

      return   ResponseEntity.ok(commandeClientService.updateEtatCommandeClient(idCommande, etatCommande));
    }

    @Override
    public ResponseEntity<CommandeClientDTO> updateQuantiteCommande(Long idCommande, Long idLigneCommande, BigDecimal newQuantitite) {
      return   ResponseEntity.ok(commandeClientService.updateQuantiteCommandeClient(idCommande,idLigneCommande,newQuantitite));
    }

    @Override
    public ResponseEntity<CommandeClientDTO> updateClient(Long idClient, Long idCommande) {

        return ResponseEntity.ok(commandeClientService.updateClient(idClient,idCommande));
    }
    @Override
    public ResponseEntity<CommandeClientDTO> updateArticle(Long idArticle, Long idLigneCommandeClient, Long idCommandeClient) {
        return ResponseEntity.ok(commandeClientService.updateArticle(idArticle,idLigneCommandeClient,idCommandeClient));
    }
    @Override
    public void deleteArticle(Long idLigneCommandeClient, Long idCommandeClient) {
        commandeClientService.deleteArticle(idLigneCommandeClient,idCommandeClient);
    }
    @Override
    public ResponseEntity<CommandeClientDTO> findById(Long id) {
        return ResponseEntity.ok(commandeClientService.findById(id));
    }

    @Override
    public ResponseEntity<CommandeClientDTO> findByNom(String nom) {
        return null ;
    }
    @Override
    public ResponseEntity<CommandeClientDTO> findByCode(String code) {
        return ResponseEntity.ok(commandeClientService.findByCode(code));
    }

    @Override
    public ResponseEntity<List<LigneCommandeClientDTO>> findAllLigneCommandeParIdClient(Long id) {

        return ResponseEntity.ok(commandeClientService.findAllLignesCommandeByClient(id));
    }
}
