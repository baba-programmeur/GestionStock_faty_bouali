package sn.faty.gestionstock.service.mappeur;

import sn.faty.gestionstock.dto.ArticleDTO;
import sn.faty.gestionstock.model.Article;

public class ArticleMappeurImpl {

    public static ArticleDTO toDto(Article article)
    {
        if(article==null)
        {
            return null ;
        }
        return ArticleDTO.builder()
                .id(article.getId())
                .designation(article.getDesignation())
                .prixUnitaire(article.getPrixUnitaire())
                .quantite(article.getQuantite())
                .nomProduit(article.getNomProduit())
                .date_creation(article.getCreatedDate())
                 .build();
    }
    public static  Article  toEntity(ArticleDTO articleDTO)
    {
        if (articleDTO==null)
        {
            return  null ;
        }
       Article article=new Article();
        article.setId(articleDTO.getId());
        article.setDesignation(articleDTO.getDesignation());
        article.setPrixUnitaire(articleDTO.getPrixUnitaire());
        article.setQuantite(articleDTO.getQuantite());
        article.setNomProduit(articleDTO.getNomProduit());
        //article.setCreatedDate(articleDTO.getC);
        return  article ;
    }
}
