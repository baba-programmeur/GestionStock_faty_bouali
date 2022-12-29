package sn.faty.gestionstock.service.mappeur;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sn.faty.gestionstock.dto.UtilisateurDTO;
import sn.faty.gestionstock.model.Utilisateur;

@Mapper(componentModel = "spring", uses = {})

public interface UtilisateurMappeur  extends EntityMapper<UtilisateurDTO,Utilisateur> {

    @Mapping(source = "", target = "")
    Utilisateur  toEntity(UtilisateurDTO utilisateurDTO);

    @Mapping(source = "", target = "")

    UtilisateurDTO toDto(Utilisateur utilisateur);


}
