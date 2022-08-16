package sn.faty.GestionStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.GestionStock.model.Ventes;

public interface VenteRepository  extends JpaRepository<Ventes,Long> {

    Ventes findVentesByCode(String code);
}
