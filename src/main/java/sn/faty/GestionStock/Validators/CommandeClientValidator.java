package sn.faty.GestionStock.Validators;

import org.springframework.util.StringUtils;
import sn.faty.GestionStock.dto.ArticleDTO;
import sn.faty.GestionStock.dto.CommandeClientDTO;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {

    public static List<String> ValideCommandeClient(CommandeClientDTO commandeClientDTO)
    {
        List<String> listErrors= new ArrayList<>();

        if(commandeClientDTO ==null)
        {
            listErrors.add("veuiller remplir le code");
            listErrors.add("Veuiller renseigner le prixUnitaire ");
            listErrors.add("Veuiller renseigner le taux TVA ");
        }
        if(! StringUtils.hasText(commandeClientDTO.getCode()))
        {

            listErrors.add("Veuiller renseigner le code");
        }
        if(commandeClientDTO.getClient()==null)
        {
            listErrors.add("Veuiller renseigner le client");
        }
        if(commandeClientDTO.getDateCommande()==null)
        {
            listErrors.add("Veuiller renseigner la date de commande  ");
        }
        return  listErrors ;

    }

}
