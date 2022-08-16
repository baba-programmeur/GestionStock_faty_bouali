package sn.faty.GestionStock.service.mappeur;

import org.mapstruct.Mapping;
import sn.faty.GestionStock.dto.VenteDTO;
import sn.faty.GestionStock.model.Ventes;

public interface VenteMappeur  extends EntityMapper<VenteDTO, Ventes> {

    @Mapping(source = "",target = "")

    Ventes toEntity(VenteDTO venteDTO);

    @Mapping(source = "",target = "")

    VenteDTO toDto(Ventes ventes);

}
