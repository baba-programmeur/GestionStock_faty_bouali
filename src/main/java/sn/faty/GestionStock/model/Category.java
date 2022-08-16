package sn.faty.GestionStock.model;

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
@Builder
@Table(name = "Category")
public class Category extends  AbstractEntity {


    private String codeCategory ;

    private String designation ;

    @OneToMany(mappedBy="category")
    private List<Article> articles ;

}
