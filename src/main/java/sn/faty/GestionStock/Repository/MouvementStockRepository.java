package sn.faty.GestionStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.GestionStock.model.MouvMntStock;

public interface MouvementStockRepository  extends JpaRepository<MouvMntStock,Long> {
}
