package sn.faty.GestionStock.service.mappeur;
import sn.faty.GestionStock.dto.EntrepriseDTO;
import sn.faty.GestionStock.model.Entreprise;


public class EntrepriseMappeurImpl {

    public static EntrepriseDTO toDto(Entreprise entreprise) {
        if(entreprise==null )
            return  null ;
        return EntrepriseDTO.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .codeFiscal(entreprise.getCodeFiscal())
                .email(entreprise.getEmail())
                .numTel(entreprise.getNumTel())
                .description(entreprise.getDescription())
                .photo((entreprise.getPhoto()))
                .adresse(entreprise.getAdresse())
                .build();
    }
    public static Entreprise toEntity(EntrepriseDTO entrepriseDTO)
    {
        if(entrepriseDTO==null)
            return  null ;

        Entreprise entreprise=new Entreprise();
        entreprise.setNom(entrepriseDTO.getNom());
        entreprise.setAdresse((entrepriseDTO.getAdresse()));
        entreprise.setCodeFiscal(entrepriseDTO.getCodeFiscal());
        entreprise.setEmail(entrepriseDTO.getEmail());
        entreprise.setDescription(entrepriseDTO.getDescription());
        entreprise.setNumTel(entrepriseDTO.getNumTel());
        entreprise.setPhoto(entrepriseDTO.getPhoto());
        return  entreprise ;

    }
}
