package sn.faty.gestionstock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.faty.gestionstock.model.EtatCommande;

import java.time.Instant;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CommandeClientDTO {
    private Long id ;
    private String  code ;
    private Instant dateCommande ;
    private EtatCommande etatCommande ;
    @JsonIgnore
    private List<LigneCommandeClientDTO> ligneCommandeClients ;
  @JsonIgnore
    private ClientDTO client ;

    public boolean isCommandeLivree(){

        if(EtatCommande.LIVREE.equals(this.etatCommande)){
            return  true  ;
        }
        return  false ;
    }
}
