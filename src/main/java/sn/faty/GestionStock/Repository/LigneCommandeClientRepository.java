package sn.faty.gestionstock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.gestionstock.model.LigneCommandeClient;

import java.util.List;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient,Long> {
                   //JPA retourne une liste de ligne de commande
                  //Par IdClient
  List<LigneCommandeClient> findAllByCommandeClientId(Long id);
  List<LigneCommandeClient> findAllByArticleId(Long idArticle);


}
