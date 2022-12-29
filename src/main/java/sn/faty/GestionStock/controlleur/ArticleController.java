package sn.faty.gestionstock.controlleur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.faty.gestionstock.controlleur.Interfaces.ArticleApi;
import sn.faty.gestionstock.dto.ArticleDTO;
import sn.faty.gestionstock.dto.LigneCommandeClientDTO;
import sn.faty.gestionstock.dto.LigneCommandeFournisseurDTO;
import sn.faty.gestionstock.dto.LigneVenteDTO;
import sn.faty.gestionstock.service.Interface.ArticleService;
import java.util.List;


@RestController
@RequestMapping
@CrossOrigin("*")
public class ArticleController implements ArticleApi {


    Logger logger= LoggerFactory.getLogger(ArticleController.class);
    private ArticleService articleService ;
    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public List<LigneVenteDTO> findHistoriqueVente(Long idArticle) {
        return articleService.findHistoriqueVente(idArticle);
    }

    @Override
    public List<LigneCommandeClientDTO> findHistoriqueCommandeClient(Long idArticle) {
        return articleService.findHistoriqueCommandeClient(idArticle);
    }

    @Override
    public List<ArticleDTO> findAllArticleByCategory(Long idCategory) {
        return articleService.findAllArticleByCategory(idCategory);
    }

    @Override
    public List<LigneCommandeFournisseurDTO> findHistoriqueCommandeFournisseur(Long idArticle) {
        return articleService.findHistoriqueCommandeFournisseur(idArticle);
    }

    @Override
    public  ArticleDTO updateArticle(ArticleDTO articleDTO) {

        logger.debug("modification de larticle {}"+articleDTO);

        return articleService.update(articleDTO);
    }

    @Override
    public ArticleDTO saveArticle(ArticleDTO articleDTO) {
        return articleService.saveArticle(articleDTO);
    }

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<ArticleDTO> findAllProducts(Pageable pageable) {
        return  articleService.findAll(pageable);
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
