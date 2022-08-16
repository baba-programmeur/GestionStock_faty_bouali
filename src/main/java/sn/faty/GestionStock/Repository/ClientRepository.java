package sn.faty.GestionStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.faty.GestionStock.model.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findClientByNom(String nom);
}
