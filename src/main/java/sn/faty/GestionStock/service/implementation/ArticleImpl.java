package sn.faty.gestionstock.service.implementation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.gestionstock.Repository.ArticleRepository;
import sn.faty.gestionstock.Repository.LigneCommandeClientRepository;
import sn.faty.gestionstock.Repository.LigneCommandeFournisseurRepository;
import sn.faty.gestionstock.Repository.LigneVenteRepository;
import sn.faty.gestionstock.Validators.ArticleValidator;
import sn.faty.gestionstock.dto.ArticleDTO;
import sn.faty.gestionstock.dto.LigneCommandeClientDTO;
import sn.faty.gestionstock.dto.LigneCommandeFournisseurDTO;
import sn.faty.gestionstock.dto.LigneVenteDTO;
import sn.faty.gestionstock.exception.EntittyNotFoundException;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.exception.InvalidOperationException;
import sn.faty.gestionstock.model.Article;
import sn.faty.gestionstock.model.LigneCommandeClient;
import sn.faty.gestionstock.model.LigneCommandeFournisseur;
import sn.faty.gestionstock.model.LigneVente;
import sn.faty.gestionstock.service.Interface.ArticleService;
import sn.faty.gestionstock.service.mappeur.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 *
 *
 */
@Slf4j
@Service
public class ArticleImpl implements ArticleService {

    Logger logger= LoggerFactory.getLogger(ArticleImpl.class);
    private ArticleRepository articleRepository ;
    private LigneVenteRepository ligneVenteRepository ;
    private LigneCommandeClientRepository ligneCommandeClientRepository ;
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository ;

    @Autowired
    public ArticleImpl(LigneVenteRepository ligneVenteRepository,
                       LigneCommandeClientRepository ligneCommandeClientRepository,
                       LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository,ArticleRepository articleRepository) {
        this.ligneVenteRepository = ligneVenteRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
        this.articleRepository=articleRepository ;
       // this.ligneCommandeClientMappeur=ligneCommandeClientMappeur ;
    }
    @Override
    public ArticleDTO saveArticle(ArticleDTO articleDTO) {

//        List<String> errors= ArticleValidator.ValideArticle(articleDTO);
//
//        if(errors.isEmpty())
//        {
//            log.debug("Article is not valid {} :",articleDTO);
//
//            throw new InvalidException("Article is not valid",ErrorCodes.ARTICLE_NOT_VALID,errors);
//        }

        return  ArticleMappeurImpl.toDto(articleRepository.save(ArticleMappeurImpl.toEntity(articleDTO)));

    }

    @Override
    public ArticleDTO update(ArticleDTO articleDTO) {

       logger.debug("article impl {}",articleDTO);

       Optional <Article> article=articleRepository.findById(articleDTO.getId());

            if(article.isEmpty()){

                throw  new EntittyNotFoundException("Cet article nexiste pas",ErrorCodes.ARTICLE_NOT_FOUND);

          }
             Article articleToUpdate=article.get();
            articleToUpdate.setQuantite(articleDTO.getQuantite());
            articleToUpdate.setNomProduit(articleDTO.getNomProduit());
            articleToUpdate.setPrixUnitaire(articleDTO.getPrixUnitaire());
            articleToUpdate.setDesignation(articleDTO.getDesignation());

       return   ArticleMappeurImpl.toDto(articleRepository.save(articleToUpdate));

       // return article1;

    }

    /**
     * @return a list of Article
     * Here I have used the fonctional programmation
     * with stream ,collect and map
     */
    @Override
    public Page<ArticleDTO> findAll(Pageable page) {
        log.debug("Request to get all Products");
        return  articleRepository.findAll(page)
                .map(ArticleMappeurImpl::toDto);
    }
    @Override
    public void deleteById(Long id) {

       if (id==null)
       {
           log.debug("id is null {}",id);
       }

      List<LigneCommandeFournisseur> ligneCommandeFournisseurs=ligneCommandeFournisseurRepository.findAllByArticleId(id);
       if(! ligneCommandeFournisseurs.isEmpty()){
           log.debug("Impossible de supprimer un article deja utilise dans une vente");
           throw  new InvalidOperationException("Impossible de supprimer un article deja utilise par un fournisseur",ErrorCodes.ARTICLE_DEJA_UTILISE);
       }

        List<LigneCommandeClient> ligneCommandeClients=ligneCommandeClientRepository.findAllByArticleId(id);
                          if(! ligneCommandeClients.isEmpty()){
                              log.debug("Impossible de supprimer un article deja utilise dans une vente");
            throw  new InvalidOperationException("Impossible de supprimer un article deja utilise par un client",ErrorCodes.ARTICLE_DEJA_UTILISE);
        }

        List<LigneVente> lignevente=ligneVenteRepository.findAllByArticleId(id);
        if(! lignevente.isEmpty()){
              log.debug("Impossible de supprimer un article deja utilise dans une vente");
            throw  new InvalidOperationException("Impossible de supprimer un article deja utilise dans une vente",ErrorCodes.ARTICLE_DEJA_UTILISE);
        }
        articleRepository.deleteById(id);
    }

    @Override
    public ArticleDTO findById(Long id) {

        if(id==null)
        {
            log.debug("Id is null {}",id);
            return null;
        }
        return ArticleMappeurImpl.toDto(articleRepository.findById(id)
                .orElseThrow(() -> new EntittyNotFoundException("Article with id :"+ id + " is not in the database",ErrorCodes.ARTICLE_NOT_FOUND)));
    }
    @Override
    public ArticleDTO findByCodeArticle(String code) {
      //  List<String> errors =new ArrayList<>();
        if(!StringUtils.hasText(code)) {
         // errors.add("Veuillez donner le code ");
            return null;
        }
        return  ArticleMappeurImpl.toDto(articleRepository.findByCodeArticle(code));
    }

    @Override
    public List<LigneVenteDTO> findHistoriqueVente(Long idArticle) {

        return    ligneVenteRepository.findAllByArticleId(idArticle)
                .stream().map(LigneVenteImpl::toDto).collect(Collectors.toList());
    }
    @Override
    public List<LigneCommandeClientDTO> findHistoriqueCommandeClient(Long idArticle) {
        LigneCommandeClientMappeur ligneCommandeClientMappeur=new LigneCommandeClientImpl();
        return ligneCommandeClientRepository.findAllByArticleId(idArticle)
                .stream().map(ligneCommandeClientMappeur::toDto).collect(Collectors.toList());
    }
    @Override
    public List<ArticleDTO> findAllArticleByCategory(Long id) {
        return articleRepository.findAllByCategoryId(id).stream().map(ArticleMappeurImpl::toDto).collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeFournisseurDTO> findHistoriqueCommandeFournisseur(Long idArticle) {
        return ligneCommandeFournisseurRepository.findAllByArticleId(idArticle).stream().map(LigneCommandeFournisseurImpl::toDto).collect(Collectors.toList());
    }
}