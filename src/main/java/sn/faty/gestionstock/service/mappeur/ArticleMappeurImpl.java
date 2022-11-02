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
        article.setCodeArticle(articleDTO.getCodeArticle());
        article.setPhoto(articleDTO.getPhoto());
        article.setPrixUnitaireHt(articleDTO.getPrixUnitaireTtc());
        article.setPrixUnitaireTtc(articleDTO.getPrixUnitaireHt());
        return  article ;
    }
}
