package sn.faty.GestionStock.dto;

import lombok.Builder;
import lombok.Data;
import sn.faty.GestionStock.model.Adresse;

@Data
@Builder
public class AdresseDTO {
    private Long id ;
    private  String adresse1;
    private  String adresse2;
    private String ville ;
    private  String  codePostal;
    private  String pays;


}
