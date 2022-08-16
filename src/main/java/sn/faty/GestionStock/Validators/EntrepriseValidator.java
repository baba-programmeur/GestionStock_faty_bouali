package sn.faty.GestionStock.Validators;

import org.springframework.util.StringUtils;
import sn.faty.GestionStock.dto.EntrepriseDTO;
import sn.faty.GestionStock.dto.FournisseurDTO;
import sn.faty.GestionStock.dto.UtilisateurDTO;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validerEntreprise(EntrepriseDTO entrepriseDTO) {

        List<String> listErrors=new ArrayList<>();

        if (entrepriseDTO == null) {

        listErrors.add("Veuiller renseigner le nom ");
        listErrors.add("Veuiller renseigner votre adresse");
        listErrors.add("Veuiller renseigner votre numero ");
        listErrors.add("Veuiller renseigner votre mail");
    }
        if (!StringUtils.hasText(entrepriseDTO.getNom())) {
        listErrors.add("Veuiller renseigner le nom ");
    }
        if (!StringUtils.hasText(entrepriseDTO.getNumTel())) {
        listErrors.add("Veuiller renseigner votre numero ");
    }
        if (!StringUtils.hasText(entrepriseDTO.getNumTel())) {
        listErrors.add("Veuiller renseigner votre numero ");
    }
        if (!StringUtils.hasText(entrepriseDTO.getEmail())) {
        listErrors.add("Veuiller renseigner votre mail ");
    }
        return listErrors;
}

}
