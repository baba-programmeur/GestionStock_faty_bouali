package sn.faty.gestionstock.service.mappeur;

import org.mapstruct.Mapping;
import sn.faty.gestionstock.dto.CommandeClientDTO;
import sn.faty.gestionstock.model.CommandeClient;

public interface CommandeClientMappeur  extends  EntityMapper<CommandeClientDTO, CommandeClient>{

    @Mapping(source = "", target = "")

    CommandeClient toEntity(CommandeClientDTO commandeClientDTO);

    @Mapping(source = "", target = "")

    CommandeClientDTO toDto(CommandeClient commandeClient);

}
