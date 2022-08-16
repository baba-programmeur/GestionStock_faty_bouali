package sn.faty.GestionStock.dto;

import lombok.Builder;
import lombok.Data;
import sn.faty.GestionStock.model.Article;
import sn.faty.GestionStock.model.CommandeFournisseur;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Builder
@Data
public class LigneCommandeFournisseurDTO {
    private Long id ;
    private ArticleDTO article;
    private CommandeFournisseurDTO commandeFournisseur ;
}
