package sn.faty.gestionstock.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name="MouvementStock")
public class MouvMntStock extends  AbstractEntity{

    private TypeMvmentStock typeMvment;
    private Instant dateMvt ;
    private BigDecimal quantite ;
    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article ;
    

}
