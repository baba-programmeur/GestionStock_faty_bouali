package sn.faty.GestionStock.controlleur;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sn.faty.GestionStock.dto.ArticleDTO;
import java.util.List;

import static sn.faty.GestionStock.controlleur.constants.Constants.APP_ROOT;

@RestController
@RequestMapping
public interface ArticleApi {

    @PostMapping(value = APP_ROOT+"/addArticle",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDTO saveArticle(@RequestBody ArticleDTO articleDTO);

    @GetMapping(value = APP_ROOT+ "/AllArticles",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDTO> findAll();

  @DeleteMapping(value=APP_ROOT+ "/deleteArticle/{id}")
    void deleteById(@PathVariable Long id);

   @GetMapping(value = APP_ROOT+"/searchArticle/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDTO findById(@PathVariable  Long id);

   @GetMapping(value = APP_ROOT+"/searchArticle/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDTO findByCodeArticle(@PathVariable  String code);
}
