package sn.faty.gestionstock.service.Interface;

import sn.faty.gestionstock.dto.MouvMntStockDTO;

import java.math.BigDecimal;
import java.util.List;

public interface MvmentStockService {

    BigDecimal quantiteReelStock(Long idArticle);

    List<MouvMntStockDTO> mvmentStock(Long idArticle);

    MouvMntStockDTO entreeStock(MouvMntStockDTO mouvMntStockDTO);

    MouvMntStockDTO sortieStock(MouvMntStockDTO mouvMntStockDTO);

    MouvMntStockDTO correctionAjoutStock(MouvMntStockDTO mouvMntStockDTO);

    MouvMntStockDTO correctionDimunitionStock(MouvMntStockDTO mouvMntStockDTO);

}
