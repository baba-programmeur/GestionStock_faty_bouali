package sn.faty.gestionstock.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Data
@Table(name="Ventes")
public class Ventes extends  AbstractEntity {

    private  String code;
    private Instant dtVente ;
    private  String commentaire ;
    @Column(name="idEntreprise")
    private int idEntreprise ;

    @OneToMany(mappedBy = "vente")
    private List<LigneVente> ligneVentes ;


    //******************reprise**********











}
