package sn.faty.gestionstock.service.Interface;

import sn.faty.gestionstock.dto.CommandeClientDTO;
import sn.faty.gestionstock.dto.LigneCommandeClientDTO;
import sn.faty.gestionstock.model.EtatCommande;
import sn.faty.gestionstock.model.LigneCommandeClient;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeClientService {

    CommandeClientDTO savecommmandeclient(CommandeClientDTO commandeClientDTO);

    List<CommandeClientDTO> findAll();

    void deleteById(Long id);

   CommandeClientDTO findById(Long id);

    CommandeClientDTO findByCode(String code);

    CommandeClientDTO updateEtatCommandeClient(Long idCommande, EtatCommande etatCommande);

    CommandeClientDTO updateQuantiteCommandeClient(Long idCommande, Long idLigneCommande, BigDecimal newQuantite);

 CommandeClientDTO updateClient(Long idClient ,Long idCommandeClient);

 CommandeClientDTO updateArticle(Long idArticle ,Long idLigneCommandeClient,Long idCommandeClient);

 void deleteArticle(Long idLigneCommandeClient ,Long idCommandeClient);

 List<LigneCommandeClientDTO> findAllLignesCommandeByClient(Long idLigneCommande);


}
