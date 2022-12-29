package sn.faty.gestionstock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.faty.gestionstock.model.Utilisateur;

import java.util.Optional;

public interface UtilisateurRepository  extends JpaRepository<Utilisateur ,Long> {

    Utilisateur findUtilisateurByNom(String nom);
    @Query(value = "select u from Utilisateur u where u.email=:email")

    Optional<Utilisateur> findUtilisateurByEmail(@Param("email") String email);
}
