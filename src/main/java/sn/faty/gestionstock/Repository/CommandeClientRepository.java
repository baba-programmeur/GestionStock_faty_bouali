package sn.faty.gestionstock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.gestionstock.model.CommandeClient;

import java.util.List;
import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Long> {

   Optional  <CommandeClient> findCommandeClientByCode(String code);

 List<CommandeClient> findCommandeClientByClientId(Long id);


    //CommandeClient findCommandeClientByCode(String code);
}
