package sn.faty.gestionstock.service.mappeur;

import org.mapstruct.Mapping;
import sn.faty.gestionstock.dto.VenteDTO;
import sn.faty.gestionstock.model.Ventes;

public interface VenteMappeur  extends EntityMapper<VenteDTO, Ventes> {

    @Mapping(source = "",target = "")

    Ventes toEntity(VenteDTO venteDTO);

    @Mapping(source = "",target = "")

    VenteDTO toDto(Ventes ventes);

}
