package sn.faty.GestionStock.Validators;
import org.springframework.util.StringUtils;
import sn.faty.GestionStock.dto.CategoryDTO;
import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDTO categoryDTO)

    {
        List errors=new ArrayList<>();

        if(categoryDTO==null || !StringUtils.hasText(categoryDTO.getCodeCategory()))
        {
            errors.add("Veuillez renseigner le code category");
        }
         if (! StringUtils.hasText(categoryDTO.getDesignation()))
         {
             errors.add("Veuillez renseigner la designation ");
         }

         return errors;

    }
}
