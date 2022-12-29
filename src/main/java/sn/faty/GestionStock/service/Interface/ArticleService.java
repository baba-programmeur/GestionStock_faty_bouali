package sn.faty.gestionstock.service.Interface;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.faty.gestionstock.dto.*;
import sn.faty.gestionstock.model.LigneCommandeClient;
import sn.faty.gestionstock.model.LigneCommandeFournisseur;
import sn.faty.gestionstock.model.LigneVente;

import java.util.List;

public interface ArticleService {
    ArticleDTO saveArticle(ArticleDTO articleDTO);
     ArticleDTO update(ArticleDTO articleDTO);

      Page<ArticleDTO> findAll(Pageable page);

    void deleteById(Long id);

    ArticleDTO findById(Long id);

    ArticleDTO findByCodeArticle(String code);

 List<LigneVenteDTO> findHistoriqueVente(Long idArticle);

 List<LigneCommandeClientDTO> findHistoriqueCommandeClient(Long idArticle);

 List<ArticleDTO> findAllArticleByCategory(Long id);

 List<LigneCommandeFournisseurDTO> findHistoriqueCommandeFournisseur(Long idArticle);


}
