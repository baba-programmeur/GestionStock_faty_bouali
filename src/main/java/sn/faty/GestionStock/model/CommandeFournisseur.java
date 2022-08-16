package sn.faty.GestionStock.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Data
@Table(name="CoommandeFournisseur")
public class CommandeFournisseur extends  AbstractEntity {

    private String codeFournisseur;

    private  Instant dateCommandeFournisseur ;

    @ManyToOne
    @JoinColumn(name="idFournisseur")
    private  Fournisseur fournisseur;

    @OneToMany(mappedBy="commandeFournisseur")
    private  List<LigneCommandeFournisseur> ligneCommandeFournisseurs ;

}
