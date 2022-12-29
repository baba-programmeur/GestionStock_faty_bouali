package sn.faty.gestionstock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import sn.faty.gestionstock.model.Roles;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolesDTO {

    public String roleName;
    private Long id ;
    private  String code;
    private UtilisateurDTO utilisateur ;


    public static RolesDTO  toDto(Roles roles){

        RolesDTO rolesDTO=new RolesDTO();

        BeanUtils.copyProperties(roles,rolesDTO);

        return  rolesDTO ;
    }

    public static  Roles toEntity(RolesDTO rolesDTO){

        Roles roles=new Roles();

        BeanUtils.copyProperties(roles,rolesDTO);

        return  roles ;
    }

}
