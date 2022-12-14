package sn.faty.gestionstock.Validators;

import org.springframework.util.StringUtils;
import sn.faty.gestionstock.dto.VenteDTO;

import java.util.ArrayList;
import java.util.List;

public class VenteValidator {

    public static List<String> validerVente(VenteDTO venteDTO) {
        List<String> listErrors = new ArrayList<>();

        if (venteDTO == null) {
            listErrors.add("Veuiller renseigner le code ");
        }
        if (!StringUtils.hasText(venteDTO.getCode())) {

            listErrors.add("Veuiller renseigner le code");
        }
        if(!StringUtils.hasText((venteDTO.getCommentaire())))
        {
            listErrors.add("Veuiller renseigner le commentaire");
        }

        return listErrors;
    }
}
