package sn.faty.GestionStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.GestionStock.model.Entreprise;

public interface EntrepriseRepository  extends JpaRepository<Entreprise,Long> {
    Entreprise findEntrepriseByNom(String nom);
}
