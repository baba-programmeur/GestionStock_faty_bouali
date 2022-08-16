package sn.faty.GestionStock.Validators;

import org.springframework.util.StringUtils;
import sn.faty.GestionStock.dto.ArticleDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 *
 */
public class ArticleValidator {

        public static List<String> ValideArticle(ArticleDTO articleDto)
        {
            List<String> listErrors= new ArrayList<>();

            if(articleDto ==null)
            {
                listErrors.add("veuiller remplir le champs CommandeClient");
                listErrors.add("Veuiller renseigner le prixUnitaire ");
                listErrors.add("Veuiller renseigner le taux TVA ");
                listErrors.add("Veuiller renseigner la designation ");
                listErrors.add("Veullez renseigner la category");
                listErrors.add("Veullez renseigner l'entreprise");

            }
            if(articleDto.getPrixUnitaireTtc()==null) {

                listErrors.add("Veuiller renseigner le prixUnitaire ");
            }
            if(articleDto.getTauxTva()==null)
            {
                listErrors.add("Veuiller renseigner le taux TVA ");
            }
            if(! StringUtils.hasText(articleDto.getCodeArticle()))
            {
                listErrors.add("Veuiller renseigner le taux TVA ");
            }
            if(! StringUtils.hasText(articleDto.getDesignation()))
            {
                listErrors.add("Veuiller renseigner la designation ");
            }
            if(articleDto.getCategory()==null)
            {
                listErrors.add("Veullez renseigner la category");
            }
            if(articleDto.getEntreprise()==null)
            {
                listErrors.add("Veullez renseigner l'entreprise");
            }
            if(articleDto.getPrixUnitaireTtc()==null)
            {
                listErrors.add("Veullez renseigner le prix Unitaire");
            }
            if(articleDto.getLigneCommandeClients()==null)
            {
                listErrors.add("veuiller remplir le champs CommandeClient");
            }
            return  listErrors ;

        }

}
