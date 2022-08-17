package sn.faty.GestionStock.service.Interface;
import sn.faty.GestionStock.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

   CategoryDTO  saveCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> findAll();

    void deleteById(Long id);

    CategoryDTO findById(Long id);

    CategoryDTO findByCodeCategory(String code);
}
