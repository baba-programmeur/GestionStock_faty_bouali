package sn.faty.gestionstock.service.strategy;

import com.flickr4java.flickr.FlickrException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.gestionstock.dto.UtilisateurDTO;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.service.Interface.FlickrServicePhoto;
import sn.faty.gestionstock.service.Interface.UtilisateurService;

import java.io.InputStream;
@Service("UtilisateurPhoto")
@Slf4j
public class SavePhotoUtilisateur implements  Strategy<UtilisateurDTO> {


    private FlickrServicePhoto flickrServicePhoto ;
    private UtilisateurService utilisateurService;

    @Autowired
    public SavePhotoUtilisateur(FlickrServicePhoto flickrServicePhoto, UtilisateurService utilisateurService) {
        this.flickrServicePhoto = flickrServicePhoto;
        this.utilisateurService=utilisateurService;
    }
    @Override
    public UtilisateurDTO savePhoto(Long id, InputStream photo, String title) throws FlickrException {

       UtilisateurDTO utilisateurDTO= utilisateurService.findById(id);

        String urlPhotoUtilisateur= flickrServicePhoto.savePhoto(photo, title);

        if(!StringUtils.hasLength(urlPhotoUtilisateur)){
            throw  new InvalidException("La photo de lentreprise nest pas sauvegrdee", ErrorCodes.SAVED_PHOTO);
        }
        utilisateurDTO.setPhoto(photo.toString());
        return     utilisateurService.saveUtilisateur(utilisateurDTO);
    }
}
