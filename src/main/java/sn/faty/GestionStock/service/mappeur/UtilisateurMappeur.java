package sn.faty.GestionStock.service.mappeur;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sn.faty.GestionStock.dto.UtilisateurDTO;
import sn.faty.GestionStock.model.Utilisateur;

@Mapper(componentModel = "spring", uses = {})

public interface UtilisateurMappeur  extends EntityMapper<UtilisateurDTO,Utilisateur> {

    @Mapping(source = "", target = "")
    Utilisateur  toEntity(UtilisateurDTO utilisateurDTO);

    @Mapping(source = "", target = "")

    UtilisateurDTO toDto(Utilisateur utilisateur);


}
