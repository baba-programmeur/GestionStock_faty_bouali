package sn.faty.GestionStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.GestionStock.model.LigneCommandeFournisseur;

public interface LigneCommandeFournisseurRepository  extends JpaRepository<LigneCommandeFournisseur,Long> {
}
