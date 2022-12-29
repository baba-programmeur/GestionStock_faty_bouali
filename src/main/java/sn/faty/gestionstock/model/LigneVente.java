package sn.faty.gestionstock.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Data
@Table(name="Detail_Vente")
public class LigneVente  extends  AbstractEntity{
    private BigDecimal quantite;
    private  BigDecimal prixUnitaire;
     @ManyToOne
    @JoinColumn(name="idArticle")
    private Article article ;
    @ManyToOne
    @JoinColumn(name="idVente")
    private Ventes vente ;

}
