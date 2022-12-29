package sn.faty.gestionstock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.gestionstock.model.Entreprise;

public interface EntrepriseRepository  extends JpaRepository<Entreprise,Long> {
    Entreprise findEntrepriseByNom(String nom);
}
