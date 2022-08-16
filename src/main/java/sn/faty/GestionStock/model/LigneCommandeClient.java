package sn.faty.GestionStock.model;

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
@Table(name="Detail_Commande")
public class LigneCommandeClient extends  AbstractEntity {

    private Double prixUnitaire ;
    private BigDecimal quantite ;
    @ManyToOne()
    @JoinColumn(name="idArticle")
    private  Article article ;
    @ManyToOne()
    @JoinColumn(name="idCommandeClient")
    private  CommandeClient commandeClient ;
}
