package sn.faty.gestionstock.controlleur;

import com.flickr4java.flickr.FlickrException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sn.faty.gestionstock.controlleur.Interfaces.PhotoApi;
import sn.faty.gestionstock.service.strategy.ContextePhoto;
import java.io.IOException;

@RestController
@RequestMapping
public class PhotoControlleur implements PhotoApi {

    private ContextePhoto contextePhoto ;

    @Autowired
    public PhotoControlleur(ContextePhoto contextePhoto) {
        this.contextePhoto = contextePhoto;
    }
    @Override
    public Object savePhoto(Long id, MultipartFile photo, String title, String contexte) throws FlickrException, IOException {

        return contextePhoto.savePhoto(id,photo.getInputStream(),title,contexte);
    }
}
