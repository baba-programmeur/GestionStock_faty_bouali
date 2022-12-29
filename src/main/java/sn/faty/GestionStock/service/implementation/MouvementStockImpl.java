package sn.faty.gestionstock.service.implementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.faty.gestionstock.Repository.MouvementStockRepository;
import sn.faty.gestionstock.Validators.MouvemenValidator;
import sn.faty.gestionstock.dto.MouvMntStockDTO;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.model.TypeMvmentStock;
import sn.faty.gestionstock.service.Interface.ArticleService;
import sn.faty.gestionstock.service.Interface.MvmentStockService;
import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class MouvementStockImpl implements MvmentStockService {
    private MouvementStockRepository mouvementStockRepository;
    private ArticleService articleService ;
    List<String> errors =null;

@Autowired
    public MouvementStockImpl(MouvementStockRepository mouvementStockRepository,ArticleService articleService) {
        this.mouvementStockRepository = mouvementStockRepository;
          this.articleService = articleService;
    }

    @Override
    public BigDecimal quantiteReelStock(Long idArticle) {

      if(idArticle==null){
          articleService.findById(idArticle);
      }
        return mouvementStockRepository.StockReel(idArticle);
    }
    @Override
    public List<MouvMntStockDTO> mvmentStock(Long idArticle) {
    //transormer un dto en entite
        return mouvementStockRepository.findAllById(idArticle);
    }
    @Override
    public MouvMntStockDTO entreeStock(MouvMntStockDTO mouvMntStockDTO) {

     return this.ajoutStock(mouvMntStockDTO,TypeMvmentStock.ENTREE);
    }
    @Override
    public MouvMntStockDTO sortieStock(MouvMntStockDTO mouvMntStockDTO) {

    return this.retraitStock(mouvMntStockDTO,TypeMvmentStock.SORTIE);
    }

    @Override
    public MouvMntStockDTO correctionAjoutStock(MouvMntStockDTO mouvMntStockDTO) {

  return  this.ajoutStock(mouvMntStockDTO,TypeMvmentStock.CORRECTION_POSITIVE);

    }
    @Override
    public MouvMntStockDTO correctionDimunitionStock(MouvMntStockDTO mouvMntStockDTO) {
    return  this.retraitStock(mouvMntStockDTO,TypeMvmentStock.CORRECTION_NEGATIVE);

    }

    //Pour des besoins de refactoring

    private MouvMntStockDTO ajoutStock(MouvMntStockDTO mouvMntStockDTO,TypeMvmentStock type){

        errors=MouvemenValidator.validerMouvment(mouvMntStockDTO);

        if(!errors.isEmpty() ) {

            throw  new InvalidException("", ErrorCodes.MOUVEMENT_STOCK);
        }
        //On s'assure que la quantite renseignee est positive

    mouvMntStockDTO.setQuantite( BigDecimal.valueOf(Math.abs(mouvMntStockDTO.getQuantite().doubleValue())));

        mouvMntStockDTO.setTypeMvment(type);

        return MouvMntStockDTO.toDto(mouvementStockRepository.save(MouvMntStockDTO.toEntity(mouvMntStockDTO)));

    }
    private MouvMntStockDTO  retraitStock(MouvMntStockDTO mouvMntStockDTO,TypeMvmentStock type){

        errors=MouvemenValidator.validerMouvment(mouvMntStockDTO);

        if(!errors.isEmpty() ) {

            throw  new InvalidException("", ErrorCodes.MOUVEMENT_STOCK);
        }
        BigDecimal.valueOf(Math.abs(mouvMntStockDTO.getQuantite().intValue())* -1) ;

        mouvMntStockDTO.setTypeMvment(type);

        return MouvMntStockDTO.toDto(mouvementStockRepository.save(MouvMntStockDTO.toEntity(mouvMntStockDTO)));
    }
}
