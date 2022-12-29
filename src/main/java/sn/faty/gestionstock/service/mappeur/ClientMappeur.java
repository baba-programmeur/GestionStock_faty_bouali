package sn.faty.gestionstock.service.mappeur;

import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;
import sn.faty.gestionstock.dto.ClientDTO;
import sn.faty.gestionstock.model.Client;


public interface ClientMappeur extends EntityMapper<ClientDTO, Client> {

    @Mapping(source = "", target = "")
   Client toEntity(ClientDTO clientDTO);

    @Mapping(source = "", target = "")

    ClientDTO toDto(Client client);


}
