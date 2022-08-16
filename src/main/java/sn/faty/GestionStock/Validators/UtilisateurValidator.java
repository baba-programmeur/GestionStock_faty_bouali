package sn.faty.GestionStock.Validators;

import org.springframework.util.StringUtils;
import sn.faty.GestionStock.dto.UtilisateurDTO;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validerUtilisateur(UtilisateurDTO utilisateurDTO)
    {
        List<String> listErrors= new ArrayList<>();

        if(utilisateurDTO ==null)
        {
            listErrors.add("Veuiller renseigner le nom ");
            listErrors.add("Veuiller renseigner le prénom ");
            listErrors.add("Veuiller renseigner le nom ");
        }
        if(!StringUtils.hasText(utilisateurDTO.getPrenom())) {

            listErrors.add("Veuiller renseigner le prénom ");
        }
        if(! StringUtils.hasText(utilisateurDTO.getNom()))
        {
            listErrors.add("Veuiller renseigner le nom ");
        }
        if(! StringUtils.hasText(utilisateurDTO.getMotDePasse()))
        {
            listErrors.add("Veuiller renseigner le mot de passe ");
        }
        if(! StringUtils.hasText(utilisateurDTO.getEmail()))
        {
            listErrors.add("Veuiller renseigner votre Email ");
        }
        if(! StringUtils.hasText(utilisateurDTO.getAdresse().getAdresse1()))
        {
            listErrors.add("Le champs adresse1 est obligatoire");
        }
        if(! StringUtils.hasText(utilisateurDTO.getAdresse().getVille()))
        {
            listErrors.add("Le champs  ville  est obligatoire");
        }
        if(! StringUtils.hasText(utilisateurDTO.getAdresse().getCodePostal()))
        {
            listErrors.add("Le champs adresse postal est obligatoire");
        }
        if(utilisateurDTO.getDateNaissance()==null)
        {
            listErrors.add("veuiller remplir le champs date de naissance ");
        }
        return  listErrors ;

    }

}
