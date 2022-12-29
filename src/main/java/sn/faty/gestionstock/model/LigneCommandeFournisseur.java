package sn.faty.gestionstock.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data

@Table(name="Detail_Fournisseur")
public class LigneCommandeFournisseur extends  AbstractEntity {
    @ManyToOne
    @JoinColumn(name="idArticle")
    private  Article article;
    @ManyToOne
    @JoinColumn(name="idCommandeFournisseur")
    private  CommandeFournisseur commandeFournisseur ;
}
