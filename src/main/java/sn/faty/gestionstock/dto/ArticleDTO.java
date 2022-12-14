package sn.faty.gestionstock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import sn.faty.gestionstock.model.*;

import java.time.Instant;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {


      private String codeArticle ;

      private  String photo ;

     private Long id ;

     private Instant date_creation ;

    private  String designation ;

    private Integer prixUnitaire;

    private String nomProduit ;

    private Integer quantite ;

    private CategoryDTO category;
    private EntrepriseDTO entreprise;
    private List<LigneCommandeFournisseurDTO> ligneCommandeFournisseurs ;
    private List<LigneCommandeClientDTO> ligneCommandeClients ;
    private List<LigneVenteDTO> ligneVentes ;
    private List<MouvMntStockDTO> mouvMntStocks ;

    public Article fromArticleDTO(ArticleDTO articleDTO)
    {
        Article article=new Article();

        BeanUtils.copyProperties(articleDTO,article);

        return  article ;
    }

    public ArticleDTO fromArticle(Article article)
    {
        ArticleDTO articleDTO=new ArticleDTO();
        BeanUtils.copyProperties(article,articleDTO);
        return  articleDTO ;
    }

}
