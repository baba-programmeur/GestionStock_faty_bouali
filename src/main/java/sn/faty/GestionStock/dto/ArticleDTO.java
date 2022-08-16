package sn.faty.GestionStock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import sn.faty.GestionStock.model.*;

import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
    private Long id ;
    private String codeArticle ;
    private  String designation ;
    private BigDecimal prixUnitaireHt ;
    private BigDecimal prixUnitaireTtc ;
    private BigDecimal tauxTva ;
    private  String photo ;
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
