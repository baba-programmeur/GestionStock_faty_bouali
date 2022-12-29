package sn.faty.gestionstock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.gestionstock.model.LigneCommandeFournisseur;

import java.util.List;

public interface LigneCommandeFournisseurRepository  extends JpaRepository<LigneCommandeFournisseur,Long> {

    List<LigneCommandeFournisseur> findAllByArticleId(Long id);

    List<LigneCommandeFournisseur> findAllByCommandeFournisseurId(Long id);
}
