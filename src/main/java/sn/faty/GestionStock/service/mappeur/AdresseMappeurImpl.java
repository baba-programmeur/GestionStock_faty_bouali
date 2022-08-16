package sn.faty.GestionStock.service.mappeur;
import sn.faty.GestionStock.dto.AdresseDTO;
import sn.faty.GestionStock.model.Adresse;

public class AdresseMappeurImpl {
    //L'utilisation des builders est un autre moyen pour
    //implementer les DTO
    public static AdresseDTO toDto(Adresse adresse)
    {
        if(adresse==null)
            return  null ;
        return    AdresseDTO.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .ville(adresse.getVille())
                .codePostal(adresse.getCodePostal())
                .build();
    }
    public static Adresse toEntity(AdresseDTO adresseDTO)
    {
        if (adresseDTO==null)
        {
            return  null ;
        }
        Adresse adresse =new Adresse();
        adresse.setAdresse1(adresseDTO.getAdresse1());
        adresse.setPays(adresseDTO.getPays());
        return  adresse ;
    }


}
