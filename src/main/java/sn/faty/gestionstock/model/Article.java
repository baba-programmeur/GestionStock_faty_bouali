package sn.faty.gestionstock.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
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

    private Integer prixUnitaire ;

    private String nomProduit ;

    private Integer quantite ;

    //private Instant date_creation;

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

    @ManyToOne
    @JoinColumn(name = "idAchat")
    private Achat achat ;

}
