package sn.faty.gestionstock.Validators;

import org.springframework.util.StringUtils;
import sn.faty.gestionstock.dto.ClientDTO;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validerClient(ClientDTO clientDTO) {

        List<String> listErrors = new ArrayList<>();

        if (clientDTO == null) {

            listErrors.add("Veuiller renseigner le nom ");
            listErrors.add("Veuiller renseigner le prénom ");
            listErrors.add("Veuiller renseigner votre adresse");
            listErrors.add("Veuiller renseigner votre numero ");
            listErrors.add("Veuiller renseigner votre mail");
        }
        if (!StringUtils.hasLength(clientDTO.getPrenom())) {

            listErrors.add("Veuiller renseigner le prénom ");
        }
        if (! StringUtils.hasLength(clientDTO.getNom())) {
            listErrors.add("Veuiller renseigner le nom ");
        }
//        if (!StringUtils.hasLength(clientDTO.getNumTel())) {
//            listErrors.add("Veuiller renseigner votre numero ");
//        }
//
//        if (!StringUtils.hasLength(clientDTO.getMail())) {
//            listErrors.add("Veuiller renseigner votre mail ");
//        }
        return listErrors;
    }

}
