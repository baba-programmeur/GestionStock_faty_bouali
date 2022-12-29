package sn.faty.gestionstock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.gestionstock.model.Ventes;

import java.util.Optional;

public interface VenteRepository  extends JpaRepository<Ventes,Long> {

   Optional<Ventes> findByCode(String code);
}
