package sn.faty.GestionStock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommandeClientDTO {
    private Long id ;
    private ArticleDTO article ;
    private CommandeClientDTO commandeClient ;
    private Double prixUnitaire ;
    private BigDecimal quantite ;
}
