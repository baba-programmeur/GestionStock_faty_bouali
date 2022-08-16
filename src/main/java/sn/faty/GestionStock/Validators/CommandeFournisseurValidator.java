package sn.faty.GestionStock.Validators;

import sn.faty.GestionStock.dto.CommandeFournisseurDTO;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {

    public  static List<String> validerCommandeFournisseur(CommandeFournisseurDTO commandeFournisseurDTO)
    {
        List<String> listErrrors=new ArrayList<>();

        if(commandeFournisseurDTO==null)
          {
              listErrrors.add("La date nest pas renseignee");

              listErrrors.add("le code fournisseur nest pas renseigné");

          }
            if(commandeFournisseurDTO.getDateCommandeFournisseur()==null){

                listErrrors.add("La date nest pas renseignee");
            }
        if(commandeFournisseurDTO.getCodeFournisseur()==null){

            listErrrors.add("le code fournisseur nest pas renseigné");
        }

        return  listErrrors ;
    }

}
