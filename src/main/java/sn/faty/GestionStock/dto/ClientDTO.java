package sn.faty.GestionStock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.faty.GestionStock.model.Adresse;
import sn.faty.GestionStock.model.CommandeClient;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private Long id ;
    private String nom ;

    private  String prenom ;

    private AdresseDTO adresse ;

    private String photo ;

    private String numTel ;

    private  String mail ;

    private List<CommandeClientDTO> commandeClients ;
}
