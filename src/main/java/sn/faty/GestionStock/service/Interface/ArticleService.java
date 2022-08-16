package sn.faty.GestionStock.service.Interface;

import sn.faty.GestionStock.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {
    ArticleDTO saveArticle(ArticleDTO articleDTO);

    List<ArticleDTO> findAll();

    void deleteById(Long id);

    ArticleDTO findById(Long id);

    ArticleDTO findByCodeArticle(String code);
}
