package sn.faty.GestionStock.dto;

import lombok.Builder;
import lombok.Data;
import sn.faty.GestionStock.model.Roles;

@Builder
@Data
public class RolesDTO {

    private Long id ;
    private  String code;
    private UtilisateurDTO utilisateur ;

}
