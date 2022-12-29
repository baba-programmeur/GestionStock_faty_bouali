package sn.faty.gestionstock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.faty.gestionstock.model.MouvMntStock;
import sn.faty.gestionstock.model.TypeMvmentStock;
import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MouvMntStockDTO {
    private Long id ;
    private TypeMvmentStock typeMvment;
    private Instant dateMvt ;
    private BigDecimal quantite ;
    private ArticleDTO article ;

    public static MouvMntStockDTO  toDto(MouvMntStock mouvMntStock) {

        if(mouvMntStock==null)
            return null;
        MouvMntStockDTO mouvMntStocke= new MouvMntStockDTO();
        mouvMntStocke.setQuantite(mouvMntStocke.getQuantite());
        mouvMntStocke.setDateMvt(mouvMntStocke.getDateMvt());
        mouvMntStocke.setTypeMvment(mouvMntStocke.getTypeMvment());
        mouvMntStocke.setId(mouvMntStocke.getId());
        return  mouvMntStocke ;
    }
//    public List<MouvMntStockDTO> listEntity(java.util.List<MouvMntStockDTO> listDto) {
//
//        if(listDto==null)
//
//            return null;
//
//        List<MouvMntStock> listMouvementStockO=new ArrayList<MouvMntStock>();
//
//        for(MouvMntStockDTO mouvMntStockDTO:listDto)
//
//            mouvMntStockDTO.add(this.toEntity(clientDto));
//
//        return listClientDTO ;
//    }
   public static MouvMntStock  toEntity(MouvMntStockDTO mouvMntStockDTO) {

    if(mouvMntStockDTO==null)
        return null;

       MouvMntStock mouvMntStocke= new MouvMntStock();
       mouvMntStocke.setQuantite(mouvMntStockDTO.getQuantite());
      // mouvMntStocke.setDateMvt(mouvMntStockDTO.setDateMvt());
       mouvMntStocke.setId(mouvMntStockDTO.getId());

       return mouvMntStocke  ;
}
}
