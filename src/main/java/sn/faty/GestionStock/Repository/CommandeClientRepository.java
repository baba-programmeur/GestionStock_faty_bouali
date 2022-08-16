package sn.faty.GestionStock.Repository;

import org.hibernate.boot.model.source.spi.JpaCallbackSource;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.GestionStock.model.CommandeClient;

import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Long> {

   Optional  <CommandeClient> findCommandeClientByCode(String code);

    //CommandeClient findCommandeClientByCode(String code);
}
