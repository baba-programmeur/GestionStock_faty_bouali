package sn.faty.gestionstock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.faty.gestionstock.model.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findClientByNom(String nom);
}
