package sn.faty.gestionstock.controlleur.Interfaces;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sn.faty.gestionstock.dto.CategoryDTO;

import java.util.List;

import static sn.faty.gestionstock.constants.Constants.APP_ROOT;

public interface CategoryApi {

    @PostMapping(value = APP_ROOT+"/addCategory",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDTO saveCategory(@RequestBody CategoryDTO categoryDTO);

    @GetMapping(value = APP_ROOT+ "/getAllCategory",produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDTO> findAll();

    @DeleteMapping(value=APP_ROOT+ "/deleteCategory/{id}")
    void deleteById(@PathVariable Long id);

    @GetMapping(value = APP_ROOT+"/searchCategory/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDTO findById(@PathVariable  Long id);

    @GetMapping(value = APP_ROOT+"/searchCategorys/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDTO findByCodeArticle(@PathVariable  String code);
}
