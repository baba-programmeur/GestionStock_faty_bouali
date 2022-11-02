package sn.faty.gestionstock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.gestionstock.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>
{
 Category findCategoryByCodeCategory(String code);

}
