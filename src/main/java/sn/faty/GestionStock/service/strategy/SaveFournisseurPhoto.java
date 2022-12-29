package sn.faty.gestionstock.service.strategy;

import com.flickr4java.flickr.FlickrException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.gestionstock.dto.FournisseurDTO;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.service.Interface.FlickrServicePhoto;
import sn.faty.gestionstock.service.Interface.FournisseurService;

import java.io.InputStream;
@Slf4j
@Service("FournisseurPhoto")
public class  SaveFournisseurPhoto  implements  Strategy<FournisseurDTO>{

    private FlickrServicePhoto flickrServicePhoto ;
    private FournisseurService fournisseurService;
    @Autowired
    public SaveFournisseurPhoto(FlickrServicePhoto flickrServicePhoto,FournisseurService fournisseurService) {
        this.flickrServicePhoto = flickrServicePhoto;
        this.fournisseurService=fournisseurService ;
    }

    @Override
    public FournisseurDTO savePhoto(Long id, InputStream photo, String title) throws FlickrException {

        FournisseurDTO fournisseurDTO = fournisseurService.findById(id);

        String urlPhotoFournisseur= flickrServicePhoto.savePhoto(photo, title);

        if(!StringUtils.hasLength(urlPhotoFournisseur)){
            throw  new InvalidException("La photo de lentreprise nest pas sauvegrdee", ErrorCodes.SAVED_PHOTO);
        }
      fournisseurDTO.setPhoto(photo.toString());
        return   fournisseurService.saveFournisseur(fournisseurDTO);
    }
}
