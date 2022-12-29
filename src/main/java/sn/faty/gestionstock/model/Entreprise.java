package sn.faty.gestionstock.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name="Entreprises")
public class Entreprise  extends  AbstractEntity{

   private  String nom ;
    private String codeFiscal ;
    private  String email ;
    private  String photo ;
    private  String numTel ;
    private String adresse ;
    private  String description ;

    @OneToMany(mappedBy="entreprise")
    private List<Utilisateur> utilisateurs ;
    @OneToMany(mappedBy="entreprise")
    private  List<Article> articles ;
}
