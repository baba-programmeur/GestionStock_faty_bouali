package sn.faty.gestionstock.Validators;

import sn.faty.gestionstock.dto.MouvMntStockDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MouvemenValidator {

  public  static List <String> validerMouvment(MouvMntStockDTO mouvMntStockDTO)
  {
    List<String> listErrors = new ArrayList<>();

        if (mouvMntStockDTO == null) {
        listErrors.add("Veuiller renseigner la quantite  ");

    }
//        if(mouvMntStockDTO.getDateMvt()==null){
//            listErrors.add("Veuiller renseigner la  date ");
//        }
        if (mouvMntStockDTO.getQuantite().compareTo(BigDecimal.ZERO)==0 || mouvMntStockDTO.getQuantite()==null) {

        listErrors.add("Veuiller renseigner la quantite");
    }
        return listErrors;

}
}
