package sn.faty.gestionstock.service.mappeur;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sn.faty.gestionstock.dto.ClientDTO;
import sn.faty.gestionstock.dto.FournisseurDTO;
import sn.faty.gestionstock.model.Client;
import sn.faty.gestionstock.model.Fournisseur;


public interface FournisseurMappeur extends EntityMapper<FournisseurDTO,Fournisseur> {

    @Mapping(source = "", target = "")
    Fournisseur toEntity(FournisseurDTO fournisseurDTO);

    @Mapping(source = "", target = "")

    FournisseurDTO toDto(Fournisseur fournisseur);


}
