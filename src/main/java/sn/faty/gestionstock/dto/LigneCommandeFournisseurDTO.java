package sn.faty.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LigneCommandeFournisseurDTO {
    private Long id ;
    private ArticleDTO article;
    private CommandeFournisseurDTO commandeFournisseur ;
}
