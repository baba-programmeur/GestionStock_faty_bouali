package sn.faty.GestionStock.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.faty.GestionStock.model.Entreprise;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntrepriseDTO {
    private Long id ;
    private  String nom ;
    private List<UtilisateurDTO> utilisateurs ;
    private  List<ArticleDTO> articles ;
    private String codeFiscal ;
    private  String email ;
    private  String photo ;
    private  String numTel ;
    private String adresse ;
    private  String description ;


}
