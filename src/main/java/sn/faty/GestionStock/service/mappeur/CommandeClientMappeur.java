package sn.faty.GestionStock.service.mappeur;

import org.mapstruct.Mapping;
import sn.faty.GestionStock.dto.CommandeClientDTO;
import sn.faty.GestionStock.model.CommandeClient;

import java.util.List;

public interface CommandeClientMappeur  extends  EntityMapper<CommandeClientDTO, CommandeClient>{

    @Mapping(source = "", target = "")

    CommandeClient toEntity(CommandeClientDTO commandeClientDTO);

    @Mapping(source = "", target = "")

    CommandeClientDTO toDto(CommandeClient commandeClient);

}
