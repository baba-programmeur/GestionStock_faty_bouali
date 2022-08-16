package sn.faty.GestionStock.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.faty.GestionStock.dto.ArticleDTO;
import sn.faty.GestionStock.service.Interface.ArticleService;
import java.util.List;


@RestController
public class ArticleController implements  ArticleApi{

    private ArticleService articleService ;
     @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ArticleDTO saveArticle(ArticleDTO articleDTO) {
        return articleService.saveArticle(articleDTO);
    }

    @Override
    public List<ArticleDTO> findAll() {
        return articleService.findAll();
    }

    @Override
    public void deleteById(Long id) {
      articleService.deleteById(id);
    }

    @Override
    public ArticleDTO findById(Long id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDTO findByCodeArticle(String code) {
        return  articleService.findByCodeArticle(code);
    }
}
