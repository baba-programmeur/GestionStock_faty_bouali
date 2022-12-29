package sn.faty.gestionstock.Validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

            Logger logger= LoggerFactory.getLogger(ArticleValidator.class);

//            if(articleDto ==null)
//            {
//                listErrors.add("Veuiller renseigner le prixUnitaire ");
//                listErrors.add("Veuiller renseigner le taux TVA ");
//                listErrors.add("Veuiller renseigner la designation ");
//            }

            if(!StringUtils.hasText(articleDto.getNomProduit())){
                listErrors.add("Veuiller renseigner le nom du produit");
                logger.debug("errorsnom {}",listErrors);
            }

            if(articleDto.getPrixUnitaire()==null){
                listErrors.add("veuiller renseigner le prix Unitaire");
                logger.debug("errorsPrix {}",listErrors);
            }
            if(!StringUtils.hasText(articleDto.getDesignation()))
            {
                listErrors.add("Veuiller renseigner la designation ");
                logger.debug("errorsDesignation {}",listErrors);
            }

            if(articleDto.getQuantite()==null) {

                listErrors.add("veuiller renseigner la quantite");
                logger.debug("errorsQuantite {}",listErrors);
            }

            logger.debug("***liste erreurs**** {}",listErrors);

            return  listErrors ;

        }

}
