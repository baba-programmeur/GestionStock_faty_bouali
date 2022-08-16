package sn.faty.GestionStock.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.GestionStock.Repository.CategoryRepository;
import sn.faty.GestionStock.Validators.CategoryValidator;
import sn.faty.GestionStock.dto.CategoryDTO;
import sn.faty.GestionStock.exception.EntittyNotFoundException;
import sn.faty.GestionStock.exception.ErrorCodes;
import sn.faty.GestionStock.exception.InvalidException;
import sn.faty.GestionStock.service.Interface.CategoryService;
import sn.faty.GestionStock.service.mappeur.ArticleMappeurImpl;
import sn.faty.GestionStock.service.mappeur.CategoryMappeurImpl;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO saveArticle(CategoryDTO categoryDTO) {

        List<String> errors= CategoryValidator.validate(categoryDTO);

        if(!errors.isEmpty())
        {
            log.debug("Article is not valid {} :",categoryDTO);

            throw new InvalidException("Article is not valid", ErrorCodes.ARTICLE_NOT_VALID,errors);
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
                .orElseThrow(() -> new EntittyNotFoundException("Article with id :"+ id + " is not in the database",ErrorCodes.ARTICLE_NOT_FOUND)));
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
