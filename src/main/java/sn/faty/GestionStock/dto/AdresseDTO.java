package sn.faty.gestionstock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import sn.faty.gestionstock.model.Adresse;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdresseDTO {

    private Long id ;
    private String adresse1;
    private  String adresse2;
    private String ville ;
    private  String  codePostal;
    private  String pays;

    public  static AdresseDTO toDto(Adresse adresse){

        AdresseDTO adresseDTO=new AdresseDTO();

        BeanUtils.copyProperties(adresse,adresseDTO);

        return  adresseDTO ;
    }
    public  static Adresse toEntity(AdresseDTO adresseDTO){

        Adresse adresse=new Adresse();

        BeanUtils.copyProperties(adresseDTO,adresse);

        return  adresse ;
    }

}
