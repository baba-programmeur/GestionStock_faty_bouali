package sn.faty.GestionStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.GestionStock.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository <Fournisseur,Long> {

       Fournisseur findFournisseurByNom(String nom);

}
