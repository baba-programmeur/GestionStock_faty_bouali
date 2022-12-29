package sn.faty.gestionstock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.gestionstock.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository <Fournisseur,Long> {

       Fournisseur findFournisseurByNom(String nom);

}
