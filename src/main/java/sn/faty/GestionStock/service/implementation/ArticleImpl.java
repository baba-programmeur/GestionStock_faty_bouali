package sn.faty.GestionStock.service.implementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.GestionStock.Repository.ArticleRepository;
import sn.faty.GestionStock.Validators.ArticleValidator;
import sn.faty.GestionStock.dto.ArticleDTO;
import sn.faty.GestionStock.exception.EntittyNotFoundException;
import sn.faty.GestionStock.exception.ErrorCodes;
import sn.faty.GestionStock.exception.InvalidException;
import sn.faty.GestionStock.service.Interface.ArticleService;
import sn.faty.GestionStock.service.mappeur.ArticleMappeurImpl;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 *
 *
 */
@Slf4j
@Service
public class ArticleImpl implements ArticleService {

    private ArticleRepository articleRepository ;

    public ArticleImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    @Override
    public ArticleDTO saveArticle(ArticleDTO articleDTO) {

        List<String> errors= ArticleValidator.ValideArticle(articleDTO);

        if(!errors.isEmpty())
        {
            log.debug("Article is not valid {} :",articleDTO);

            throw new InvalidException("Article is not valid",ErrorCodes.ARTICLE_NOT_VALID,errors);
        }
         //   Article article= articleRepository.save(ArticleMappeurImpl.toEntity(articleDTO));
        return  ArticleMappeurImpl.toDto( articleRepository.save(ArticleMappeurImpl.toEntity(articleDTO)));

    }

    /**
     * @return a list of Article
     * Here I have used the fonctional programmation
     * with stream ,collect and map
     */
    @Override
    public List<ArticleDTO> findAll() {
        return  articleRepository.findAll().stream()
                .map(ArticleMappeurImpl::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteById(Long id) {

       if (id==null)
       {
           log.debug("id is null {}",id);
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
}