package sn.faty.gestionstock.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.gestionstock.Repository.ArticleRepository;
import sn.faty.gestionstock.Repository.CategoryRepository;
import sn.faty.gestionstock.Validators.CategoryValidator;
import sn.faty.gestionstock.dto.CategoryDTO;
import sn.faty.gestionstock.exception.EntittyNotFoundException;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.exception.InvalidOperationException;
import sn.faty.gestionstock.model.Article;
import sn.faty.gestionstock.service.Interface.CategoryService;
import sn.faty.gestionstock.service.mappeur.CategoryMappeurImpl;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ArticleRepository articleRepository ;

@Autowired
    public CategoryImpl(CategoryRepository categoryRepository, ArticleRepository articleRepository) {
        this.categoryRepository = categoryRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {

        List<String> errors= CategoryValidator.validateCategory(categoryDTO);

        if(!errors.isEmpty())
        {
            log.debug("Article is not valid {} :",categoryDTO);

            throw new InvalidException("Article is not valid", ErrorCodes.CATEGORY_NOT_VALID,errors);
        }

        return  CategoryMappeurImpl.toDto(categoryRepository.save(CategoryMappeurImpl.toEntity(categoryDTO)));

    }

    @Override
    public List<CategoryDTO> findAll() {
        return  categoryRepository.findAll().stream()
                .map(CategoryMappeurImpl::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if (id==null)
        {
            log.debug("id is null {}");
        }

    List<Article> listeArticle=articleRepository.findAllByCategoryId(id);

        if(! listeArticle.isEmpty()){
            log.debug("Impossible de supprimer une categorie deja utilise dans un  artciecle");
            throw  new InvalidOperationException("Impossible de supprimer un article deja utilise dans une artcicle",ErrorCodes.CATEGORY_DEJA_UTILISE);
        }

        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDTO findById(Long id) {
        if(id==null)
        {
            log.debug("Id is null {}",id);
            return null;
        }
        return CategoryMappeurImpl.toDto(categoryRepository.findById(id)
                .orElseThrow(() -> new EntittyNotFoundException("Article with id :"+ id + " is not in the database",ErrorCodes.CATEGORY_NOT_FOUND)));
    }

    @Override
    public CategoryDTO findByCodeCategory(String code) {
        //  List<String> errors =new ArrayList<>();
        if(!StringUtils.hasText(code)) {
            return null;
        }
        return    CategoryMappeurImpl.toDto(categoryRepository.findCategoryByCodeCategory(code))   ;

    }
}
