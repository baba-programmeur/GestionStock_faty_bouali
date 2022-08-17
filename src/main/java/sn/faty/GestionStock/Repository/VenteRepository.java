package sn.faty.GestionStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.GestionStock.model.Ventes;

import java.util.Optional;

public interface VenteRepository  extends JpaRepository<Ventes,Long> {

   Optional<Ventes> findVentesByCode(String code);
}
