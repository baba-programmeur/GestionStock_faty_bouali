package sn.faty.gestionstock.Validators;

import org.springframework.util.StringUtils;
import sn.faty.gestionstock.dto.FournisseurDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validerFournisseur(FournisseurDTO fournisseurDTO) {

        List<String> listErrors = new ArrayList<>();

        if (fournisseurDTO == null) {
            listErrors.add("Veuiller renseigner le nom ");
            for (String s : Arrays.asList("Veuiller renseigner le prénom ", "Veuiller renseigner votre adresse", "Veuiller renseigner votre numero ", "Veuiller renseigner votre mail")) {
                listErrors.add(s);
            }
        }
        if (! StringUtils.hasLength(fournisseurDTO.getPrenom())) {

            listErrors.add("Veuiller renseigner le prénom ");
        }
        if (!StringUtils.hasLength(fournisseurDTO.getNom())) {
            listErrors.add("Veuiller renseigner le nom ");
        }
        if (!StringUtils.hasLength(fournisseurDTO.getNumTel())) {
            listErrors.add("Veuiller renseigner votre numero ");
        }
        if (!StringUtils.hasText(fournisseurDTO.getMail())) {
            listErrors.add("Veuiller renseigner votre mail ");
        }
//        if(! StringUtils.hasLength(fournisseurDTO.getAdresse().getAdresse1())){
//            listErrors.add("Veuiller renseigner votre adresse");
//        }
        return listErrors;
    }

    }
