package sn.faty.gestionstock.service.mappeur;

import org.mapstruct.Mapping;
import sn.faty.gestionstock.dto.LigneCommandeClientDTO;
import sn.faty.gestionstock.model.LigneCommandeClient;

public interface LigneCommandeClientMappeur  extends EntityMapper<LigneCommandeClientDTO, LigneCommandeClient> {

    @Mapping(source = "", target = "")
    LigneCommandeClient toEntity(LigneCommandeClientDTO ligneCommandeClientDTO);

    @Mapping(source = "", target = "")

    LigneCommandeClientDTO toDto(LigneCommandeClient ligneCommandeClient);
}
