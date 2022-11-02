package sn.faty.gestionstock.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "Clients")
public class Client extends  AbstractEntity {

    private String nom ;

    private  String prenom ;
    @Embedded
    private Adresse adresse ;

    private String photo ;
    @Column(name="NumeroTelephone")

    private String numTel ;

    @Column(name="Email",unique = true)

    private  String mail ;

    @Column(name="idEntreprise")
    private int idEntreprise ;

    @OneToMany(mappedBy="client")
    private List<CommandeClient> commandeClients ;

}
