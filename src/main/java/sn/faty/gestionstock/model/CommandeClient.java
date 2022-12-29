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
public class CommandeClient extends  AbstractEntity {
  private String  code ;
  private Instant dateCommande ;
  @Column(name="idEntreprise")
  private int idEntreprise ;
  private  EtatCommande etatCommande ;

  @OneToMany(mappedBy="commandeClient")

  private List<LigneCommandeClient> ligneCommandeClients ;
    @ManyToOne
    @JoinColumn(name="idClient")
    private Client client ;
}
