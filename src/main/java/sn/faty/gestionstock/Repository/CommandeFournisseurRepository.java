package sn.faty.gestionstock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.gestionstock.model.CommandeFournisseur;

import java.util.List;
import java.util.Optional;

public interface CommandeFournisseurRepository  extends JpaRepository<CommandeFournisseur,Long> {

    Optional<CommandeFournisseur> findCommandeFournisseurByCodeFournisseur(String code);

    List <CommandeFournisseur> findAllByFournisseurId(Long id);
}
