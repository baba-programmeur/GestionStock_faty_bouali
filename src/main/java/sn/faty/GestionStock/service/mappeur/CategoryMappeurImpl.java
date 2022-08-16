package sn.faty.GestionStock.service.mappeur;

import sn.faty.GestionStock.dto.CategoryDTO;
import sn.faty.GestionStock.model.Category;

public class CategoryMappeurImpl {

    public static CategoryDTO toDto(Category category)
    {
        if(category==null)
        {
            return null ;
        }
        return  CategoryDTO.builder()
                .id(category.getId())
                .codeCategory(category.getCodeCategory())
                .designation(category.getDesignation())
                .build();
    }
    public static Category toEntity(CategoryDTO categoryDTO)
    {
        if (categoryDTO==null)
        {
            return  null ;
        }

        Category category=new Category();
        category.setId(category.getId());
        category.setDesignation(categoryDTO.getDesignation());
        category.setCodeCategory(categoryDTO.getCodeCategory());

        return  category ;
    }
}
