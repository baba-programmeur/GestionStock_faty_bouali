package sn.faty.GestionStock.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.GestionStock.model.LigneVente;

public interface LigneVenteRepository  extends JpaRepository<LigneVente,Long> {
}
