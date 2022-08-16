package sn.faty.GestionStock.service.mappeur;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sn.faty.GestionStock.dto.FournisseurDTO;
import sn.faty.GestionStock.model.Fournisseur;

@Mapper(componentModel = "spring", uses = {})
public interface FournisseurMappeur extends EntityMapper<FournisseurDTO,Fournisseur> {

    @Mapping(source = "", target = "")
    Fournisseur toEntity(Fournisseur fournisseur);

    @Mapping(source = "", target = "")

    FournisseurDTO toDto(Fournisseur fournisseur);


}
