package sn.faty.gestionstock.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data

@Table(name = "Articles")
public class Article extends  AbstractEntity {

    @Column(name = "CodeArticle")
    private String codeArticle ;
    private  String designation ;
    private Integer prixUnitaireHt ;
    private Integer prixUnitaireTtc ;
    private Integer tauxTva ;
    private  String photo ;
    @Column(name="code_idEntreprise")
    private int idEntreprise ;

    @ManyToOne
    @JoinColumn(name="idCategory")
    private Category category;

    @ManyToOne
    @JoinColumn(name="idEntreprise")
    private Entreprise entreprise;

    @OneToMany(mappedBy="article")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs ;

    @OneToMany(mappedBy="article")
    private List<LigneCommandeClient> ligneCommandeClients ;

    @OneToMany(mappedBy = "article")
    private List<LigneVente> ligneVentes ;

    @OneToMany(mappedBy = "article")
    private List<MouvMntStock> mouvMntStocks ;

}
