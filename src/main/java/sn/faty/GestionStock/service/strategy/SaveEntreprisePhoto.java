package sn.faty.gestionstock.service.strategy;

import com.flickr4java.flickr.FlickrException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.gestionstock.dto.EntrepriseDTO;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.service.Interface.ArticleService;
import sn.faty.gestionstock.service.Interface.EntrepriseService;
import sn.faty.gestionstock.service.Interface.FlickrServicePhoto;

import java.io.InputStream;

@Service("EntreprisePhoto")
@Slf4j
public class SaveEntreprisePhoto implements  Strategy<EntrepriseDTO>{

    private FlickrServicePhoto flickrServicePhoto ;
    private EntrepriseService entrepriseService;
@Autowired
    public SaveEntreprisePhoto(FlickrServicePhoto flickrServicePhoto,EntrepriseService entrepriseService) {
        this.flickrServicePhoto = flickrServicePhoto;
        this.entrepriseService = entrepriseService;
    }

    @Override
    public EntrepriseDTO savePhoto(Long id, InputStream photo, String title) throws FlickrException {

    EntrepriseDTO entrepriseDTO= entrepriseService.findById(id);

    String urlPhotoEntreprise= flickrServicePhoto.savePhoto(photo, title);

    if(!StringUtils.hasLength(urlPhotoEntreprise)){
        throw  new InvalidException("La photo de lentreprise nest pas sauvegrdee", ErrorCodes.SAVED_PHOTO);
    }
           entrepriseDTO.setPhoto(photo.toString());
    return     entrepriseService.saveEntreprise(entrepriseDTO);
    }
}
