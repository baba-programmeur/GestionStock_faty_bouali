package sn.faty.gestionstock.service.Interface;
import sn.faty.gestionstock.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

   CategoryDTO  saveCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> findAll();

    void deleteById(Long id);

    CategoryDTO findById(Long id);

    CategoryDTO findByCodeCategory(String code);
}
