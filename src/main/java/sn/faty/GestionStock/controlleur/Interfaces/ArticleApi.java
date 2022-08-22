package sn.faty.GestionStock.controlleur.Interfaces;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sn.faty.GestionStock.dto.ArticleDTO;
import java.util.List;

import static sn.faty.GestionStock.constants.Constants.APP_ROOT;


//@Api(APP_ROOT+"/articles")

public interface ArticleApi {

    @PostMapping(value = APP_ROOT+"/addArticle",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
  /*  @ApiOperation(value="Save a article",notes = "This fnction save article in the Database",response = ArticleDTO.class)
   @ApiResponses(value= {

           @ApiResponse(code=200,message = "article sauvegarde ou modifié"),
           @ApiResponse(code=404,message="Article non sauvegarde")

   })
   */

    ArticleDTO saveArticle(@RequestBody ArticleDTO articleDTO);
  /*
    @ApiOperation(value="find all articles",notes = "This fnction get All article in the Database",responseContainer ="List<ArticleDTO>")

    @ApiResponses(value= {

            @ApiResponse(code=200,message = "tous les articles sont trouves"),
            @ApiResponse(code=404,message="Articles non trouves")

    })

   */
    @GetMapping(value = APP_ROOT+ "/AllArticles",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDTO> findAll();

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
   @GetMapping(value = APP_ROOT+"/searchArticle/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDTO findByCodeArticle(@PathVariable  String code);
}
