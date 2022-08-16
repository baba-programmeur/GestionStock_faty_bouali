package sn.faty.GestionStock.service.mappeur;

import sn.faty.GestionStock.dto.ArticleDTO;
import sn.faty.GestionStock.model.Article;

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
                .codeArticle(article.getCodeArticle())
                 .build();
    }
    public static  Article  toEntity(ArticleDTO articleDTO)
    {
        if (articleDTO==null)
        {
            return  null ;
        }
       Article article=new Article();
        article.setId(article.getId());
        article.setDesignation(articleDTO.getDesignation());
        return  article ;
    }
}
