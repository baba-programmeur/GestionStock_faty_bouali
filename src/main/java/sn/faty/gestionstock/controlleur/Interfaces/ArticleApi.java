package sn.faty.gestionstock.controlleur.Interfaces;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sn.faty.gestionstock.dto.ArticleDTO;
import sn.faty.gestionstock.dto.LigneCommandeClientDTO;
import sn.faty.gestionstock.dto.LigneCommandeFournisseurDTO;
import sn.faty.gestionstock.dto.LigneVenteDTO;

import java.util.List;

import static sn.faty.gestionstock.constants.Constants.APP_ROOT;


//@Api(APP_ROOT+"/articles")

public interface ArticleApi {


    @PostMapping(value = APP_ROOT+"/addArticle",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)

    ArticleDTO saveArticle(@RequestBody ArticleDTO articleDTO);
  /*
    @ApiOperation(value="find all articles",notes = "This fnction get All article in the Database",responseContainer ="List<ArticleDTO>")

    @ApiResponses(value= {

            @ApiResponse(code=200,message = "tous les articles sont trouves"),
            @ApiResponse(code=404,message="Articles non trouves")

    })

   */
    @GetMapping(value = APP_ROOT+ "/AllArticles",produces = MediaType.APPLICATION_JSON_VALUE)

    Page<ArticleDTO> findAllProducts(Pageable pageable);

/*
    @ApiOperation(value="delete a article",notes = "This fnction delete an article in the Database")
    @ApiResponses(value= {

            @ApiResponse(code=200,message = "article sauvegarde ou modifié"),
            @ApiResponse(code=404,message="Article non sauvegarde")
    })

 */
  @DeleteMapping(value=APP_ROOT+ "/deleteArticle/{id}")
    void deleteById(@PathVariable Long id);



/*
    @ApiOperation(value="Save a article",notes = "This fnction save article in the Database",response = ArticleDTO.class)
    @ApiResponses(value= {

            @ApiResponse(code=200,message = "article sauvegarde ou modifié"),
            @ApiResponse(code=404,message="Article non sauvegarde")
    })

 */
   @GetMapping(value = APP_ROOT+"/searchArticle/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDTO findById(@PathVariable  Long id);

   /*
    @ApiOperation(value="Save a article",notes = "This fnction save article in the Database",response = ArticleDTO.class)
    @ApiResponses(value= {
            @ApiResponse(code=200,message = "article sauvegarde ou modifié"),
            @ApiResponse(code=404,message="Article non sauvegarde")
    })

    */
   @GetMapping(value = APP_ROOT+"/searchArticleBy/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDTO findByCodeArticle(@PathVariable  String code);


    @GetMapping(value = APP_ROOT+"/historique/vente/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
   List<LigneVenteDTO> findHistoriqueVente(@PathVariable Long idArticle);

    @GetMapping(value = APP_ROOT+"/historique/commandeClient/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)

  List<LigneCommandeClientDTO> findHistoriqueCommandeClient(@PathVariable Long idArticle);

    @GetMapping(value = APP_ROOT+"/historique/filtre/{idCategory}",produces = MediaType.APPLICATION_JSON_VALUE)

    List<ArticleDTO> findAllArticleByCategory(@PathVariable Long idCategory);

    @GetMapping(value = APP_ROOT+"/historique/commandeFournisseur/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)

    List<LigneCommandeFournisseurDTO> findHistoriqueCommandeFournisseur(@PathVariable Long idArticle);


    @PutMapping(value=APP_ROOT+"/updateArticle",produces = MediaType.APPLICATION_JSON_VALUE)

      ArticleDTO  updateArticle(@RequestBody ArticleDTO articleDTO);

}
