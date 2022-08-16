package sn.faty.GestionStock.Validators;

import org.springframework.util.StringUtils;
import sn.faty.GestionStock.dto.FournisseurDTO;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validerFournisseur(FournisseurDTO fournisseurDTO) {

        List<String> listErrors = new ArrayList<>();

        if (fournisseurDTO == null) {
            listErrors.add("Veuiller renseigner le nom ");
            listErrors.add("Veuiller renseigner le prénom ");
            listErrors.add("Veuiller renseigner votre adresse");
            listErrors.add("Veuiller renseigner votre numero ");
            listErrors.add("Veuiller renseigner votre mail");
        }
        if (!StringUtils.hasText(fournisseurDTO.getPrenom())) {

            listErrors.add("Veuiller renseigner le prénom ");
        }
        if (!StringUtils.hasText(fournisseurDTO.getNom())) {
            listErrors.add("Veuiller renseigner le nom ");
        }
        if (!StringUtils.hasText(fournisseurDTO.getNumTel())) {
            listErrors.add("Veuiller renseigner votre numero ");
        }
        if (!StringUtils.hasText(fournisseurDTO.getNumTel())) {
            listErrors.add("Veuiller renseigner votre numero ");
        }
        if (!StringUtils.hasText(fournisseurDTO.getMail())) {
            listErrors.add("Veuiller renseigner votre mail ");
        }
        return listErrors;
    }

    }
