package sn.faty.GestionStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.GestionStock.model.Utilisateur;

public interface UtilisateurRepository  extends JpaRepository<Utilisateur ,Long> {

    Utilisateur findUtilisateurByNom(String nom);
}
