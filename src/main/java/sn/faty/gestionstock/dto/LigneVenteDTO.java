package sn.faty.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneVenteDTO {
    private Long id ;
    private ArticleDTO article ;
    private VenteDTO vente ;
    private BigDecimal quantite;
    private  BigDecimal prixUnitaire;

}
