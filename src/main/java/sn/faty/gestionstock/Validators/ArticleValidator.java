package sn.faty.gestionstock.Validators;

import org.springframework.util.StringUtils;
import sn.faty.gestionstock.dto.ArticleDTO;

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
                listErrors.add("Veuiller renseigner le prixUnitaire ");
                listErrors.add("Veuiller renseigner le taux TVA ");
                listErrors.add("Veuiller renseigner la designation ");
            }

            if(articleDto.getPrixUnitaireHt()==null){
                listErrors.add("veuiller renseigner le prix htt");
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
                listErrors.add("Veuiller renseigner le code ");
            }
            if(! StringUtils.hasText(articleDto.getDesignation()))
            {
                listErrors.add("Veuiller renseigner la designation ");
            }

            return  listErrors ;

        }

}
