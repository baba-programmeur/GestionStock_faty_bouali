package sn.faty.gestionstock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sn.faty.gestionstock.dto.MouvMntStockDTO;
import sn.faty.gestionstock.model.MouvMntStock;

import java.math.BigDecimal;
import java.util.List;

public interface MouvementStockRepository  extends JpaRepository<MouvMntStock,Long> {
   @Query("select sum (m.quantite) from MouvMntStock m where m.article.id=:idArticle")

   BigDecimal StockReel(Long idArticle);
   @Query("select m from MouvMntStock m where m.article.id=:idArticle")

   List<MouvMntStock> mvmentStock(Long idArticle);
   List<MouvMntStockDTO> findAllById (Long id);

}
