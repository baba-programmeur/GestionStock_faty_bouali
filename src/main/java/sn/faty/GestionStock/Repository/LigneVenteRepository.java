package sn.faty.gestionstock.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.gestionstock.model.LigneVente;

import java.util.List;

public interface LigneVenteRepository  extends JpaRepository<LigneVente,Long> {

    List<LigneVente> findAllByArticleId(Long id);

    List<LigneVente> findAllByVenteId(Long id);
}
