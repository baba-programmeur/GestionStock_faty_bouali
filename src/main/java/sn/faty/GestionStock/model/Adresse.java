package sn.faty.GestionStock.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
@Table(name = "Addresse")
@Embeddable
//La classe est embeddable veut  dire ces champs peuvent etre utilises dans dautres classes

public class Adresse {

    private  String adresse1;
    private  String adresse2;

    private String ville ;
    private  String  codePostal;
    private  String pays;
}
