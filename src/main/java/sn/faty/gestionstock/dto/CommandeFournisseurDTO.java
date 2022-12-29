package sn.faty.gestionstock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommandeFournisseurDTO {
    private Long id ;
    private String codeFournisseur;
    private Instant dateCommandeFournisseur ;
    private FournisseurDTO fournisseur;
   @JsonIgnore
    private List<LigneCommandeFournisseurDTO> ligneCommandeFournisseurs ;
}
