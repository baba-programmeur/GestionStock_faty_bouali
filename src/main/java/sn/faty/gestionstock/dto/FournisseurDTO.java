package sn.faty.gestionstock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FournisseurDTO {
    private Long id ;
    private String nom ;
    private  String prenom ;
    private AdresseDTO adresse ;
    private String photo ;
    private String numTel ;
    private  String mail ;
    private List<CommandeFournisseurDTO> commandeFournisseurs ;
}
