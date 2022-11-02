package sn.faty.gestionstock.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Data
@Builder
@Table(name = "Category")
public class Category extends  AbstractEntity {


    private String codeCategory ;
    private String designation ;
    @Column(name="idEntreprise",nullable = true)
    private int idEntreprise ;

    @OneToMany(mappedBy="category")
    private List<Article> articles ;

}
