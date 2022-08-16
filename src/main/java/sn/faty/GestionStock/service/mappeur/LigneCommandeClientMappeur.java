package sn.faty.GestionStock.service.mappeur;

import org.mapstruct.Mapping;
import sn.faty.GestionStock.dto.LigneCommandeClientDTO;
import sn.faty.GestionStock.model.LigneCommandeClient;

public interface LigneCommandeClientMappeur  extends EntityMapper<LigneCommandeClientDTO, LigneCommandeClient> {

    @Mapping(source = "", target = "")
    LigneCommandeClient toEntity(LigneCommandeClientDTO ligneCommandeClientDTO);

    @Mapping(source = "", target = "")

    LigneCommandeClientDTO toDto(LigneCommandeClient ligneCommandeClient);
}
