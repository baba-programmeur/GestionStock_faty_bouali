package sn.faty.GestionStock.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Data
@Table(name="Fournisseurs")
public class Fournisseur extends  AbstractEntity{

    private String nom ;

    private  String prenom ;
    @Embedded
    private Adresse adresse ;

    private String photo ;
    @Column(name="NumeroTelephone")

    private String numTel ;

    @Column(name="Email",unique=true)

    private  String mail ;
    @OneToMany(mappedBy="fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs ;
}
