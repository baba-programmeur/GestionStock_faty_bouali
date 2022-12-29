package sn.faty.gestionstock.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data

@Table(name="Achat")

public class Achat extends  AbstractEntity{

    private Long prixUnitaire ;

    private String nomProduit ;

    private Integer quantite ;

    private String photo ;

    @ManyToOne
    @JoinColumn(name="idFournisseur")
    private  Fournisseur fournisseur ;

    @OneToMany(mappedBy="achat")

    private List<Article> articles ;


}
