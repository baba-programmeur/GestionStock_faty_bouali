package sn.faty.GestionStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.GestionStock.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>
{
 Category findCategoryByCodeCategory(String code);

}
