package sn.faty.GestionStock.dto;

import lombok.Builder;
import lombok.Data;
import sn.faty.GestionStock.model.Article;
import sn.faty.GestionStock.model.Ventes;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
