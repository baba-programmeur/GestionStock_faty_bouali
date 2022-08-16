package sn.faty.GestionStock.dto;

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
    private List<LigneCommandeFournisseurDTO> ligneCommandeFournisseurs ;
}
