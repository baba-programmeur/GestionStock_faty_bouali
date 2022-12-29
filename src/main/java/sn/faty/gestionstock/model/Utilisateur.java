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
@Table(name="Utilisateur")
public class Utilisateur extends  AbstractEntity {

    private  String nom ;
    private  String prenom;
    @Embedded
    private  Adresse adresse ;
    private Instant dateNaissance;

    private  String email;

    private  String motDePasse ;
    private  String photo ;
    @OneToMany(mappedBy = "utilisateur")
    private List<Roles> roles ;
    @ManyToOne
    @JoinColumn(name="idEntreprise")
    private Entreprise entreprise;
}