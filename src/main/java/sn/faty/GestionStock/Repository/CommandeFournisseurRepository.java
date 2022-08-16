package sn.faty.GestionStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.GestionStock.model.CommandeFournisseur;

import java.util.Optional;

public interface CommandeFournisseurRepository  extends JpaRepository<CommandeFournisseur,Long> {

    Optional<CommandeFournisseur> findCommandeFournisseurByCodeFournisseur(String code);

}
