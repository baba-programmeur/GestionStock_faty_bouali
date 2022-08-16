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
@Table(name="CommandeDesClients")
public class CommandeClient extends  AbstractEntity {

  private String  code ;
  private Instant dateCommande ;

  @OneToMany(mappedBy="commandeClient")
  private List<LigneCommandeClient> ligneCommandeClients ;
    @ManyToOne
    @JoinColumn(name="idClient")
    private Client client ;
}
