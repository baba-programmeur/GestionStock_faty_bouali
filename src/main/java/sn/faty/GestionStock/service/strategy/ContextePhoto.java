package sn.faty.gestionstock.service.strategy;

import com.flickr4java.flickr.FlickrException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;

import java.io.InputStream;

@Service
public class ContextePhoto {

    private Strategy strategy;
    private BeanFactory beanFactory;

    @Autowired
    public ContextePhoto(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object savePhoto(Long id, InputStream photo, String title, String contexte) throws FlickrException {
        this.determinerContexte(contexte);
        return strategy.savePhoto(id, photo, title);
    }

    private void determinerContexte(String contexte) {

     final String beanName= contexte+ "Strategy";

        switch (contexte) {

            case "article":
                strategy = beanFactory.getBean(beanName,SaveArticlePhoto.class);
            case "client":
                break;
            case "utilisateur":
                strategy = beanFactory.getBean(beanName,SavePhotoUtilisateur.class);
                break;
            case "entreprise":
                strategy = beanFactory.getBean(beanName, SaveEntreprisePhoto.class);
                break;
            case "fournisseur":
                strategy = beanFactory.getBean(beanName, SaveFournisseurPhoto.class);
                break;
            default:
                throw new InvalidException("Erreur lors de la sauvegarde de la photo", ErrorCodes.SAVED_PHOTO);

        }

    }

}