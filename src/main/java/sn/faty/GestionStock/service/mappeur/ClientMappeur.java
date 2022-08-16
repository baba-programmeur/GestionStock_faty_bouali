package sn.faty.GestionStock.service.mappeur;

import org.mapstruct.Mapping;
import sn.faty.GestionStock.dto.ClientDTO;
import sn.faty.GestionStock.model.Client;

public interface ClientMappeur extends EntityMapper<ClientDTO, Client> {

    @Mapping(source = "", target = "")
   Client toEntity(ClientDTO clientDTO);

    @Mapping(source = "", target = "")

    ClientDTO toDto(Client client);


}
