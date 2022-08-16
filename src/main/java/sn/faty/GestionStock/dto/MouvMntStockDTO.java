package sn.faty.GestionStock.dto;

import lombok.Builder;
import lombok.Data;
import sn.faty.GestionStock.model.Article;
import sn.faty.GestionStock.model.TypeMvmentStock;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class MouvMntStockDTO {
    private Long id ;
    private TypeMvmentStock typeMvment;
    private Instant dateMvt ;
    private BigDecimal quantite ;
    private ArticleDTO article ;
}
