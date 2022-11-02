package sn.faty.gestionstock.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.faty.gestionstock.controlleur.Interfaces.CategoryApi;
import sn.faty.gestionstock.dto.CategoryDTO;
import sn.faty.gestionstock.service.Interface.CategoryService;

import java.util.List;
@RestController
@RequestMapping
public class CategoryController implements CategoryApi {

    private CategoryService categoryService ;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {

        return  categoryService.saveCategory(categoryDTO);
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void deleteById(Long id) {
       categoryService.deleteById(id);
    }

    @Override
    public CategoryDTO findById(Long id) {
        return categoryService.findById(id);
    }

    @Override
    public CategoryDTO findByCodeArticle(String code) {
        return categoryService.findByCodeCategory(code);
    }
}
