package sn.faty.gestionstock.service.strategy;

import com.flickr4java.flickr.FlickrException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.gestionstock.dto.ArticleDTO;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.service.Interface.ArticleService;
import sn.faty.gestionstock.service.Interface.FlickrServicePhoto;

import java.io.InputStream;

@Service("ArticlePhoto")
@Slf4j
public class  SaveArticlePhoto  implements  Strategy<ArticleDTO>{

    private FlickrServicePhoto flickrServicePhoto ;
    private ArticleService articleService ;

    @Autowired
    public SaveArticlePhoto(FlickrServicePhoto flickrServicePhoto, ArticleService articleService) {
        this.flickrServicePhoto = flickrServicePhoto;
        this.articleService = articleService;
    }
    @Override
    public ArticleDTO savePhoto(Long id, InputStream photo, String title) throws FlickrException {

      ArticleDTO articleDTO= articleService.findById(id);

      String  urlPhoto= flickrServicePhoto.savePhoto(photo, title);

      if(!StringUtils.hasLength(urlPhoto)){
          throw  new InvalidException("Cette photo nest pas sauvegardee", ErrorCodes.SAVED_PHOTO);
      }
         articleDTO.setPhoto(photo.toString());
      return  articleService.saveArticle(articleDTO);
    }

}
