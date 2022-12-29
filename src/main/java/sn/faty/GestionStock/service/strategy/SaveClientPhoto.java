package sn.faty.gestionstock.service.strategy;

import com.flickr4java.flickr.FlickrException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.gestionstock.dto.ClientDTO;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.service.Interface.ClientService;
import sn.faty.gestionstock.service.Interface.FlickrServicePhoto;

import java.io.InputStream;

@Service("ClientPhoto")
@Slf4j
public class SaveClientPhoto implements Strategy<ClientDTO>{


    private FlickrServicePhoto flickrServicePhoto ;
    private ClientService clientService;

    @Autowired
    public SaveClientPhoto(FlickrServicePhoto flickrServicePhoto,ClientService clientService) {
        this.flickrServicePhoto = flickrServicePhoto;
        this.clientService=clientService;
    }

    @Override
    public ClientDTO savePhoto(Long id, InputStream photo, String title) throws FlickrException {

       ClientDTO clientDTO= clientService.findById(id);

        String urlPhotoClient= flickrServicePhoto.savePhoto(photo, title);

        if(!StringUtils.hasLength(urlPhotoClient)){
            throw  new InvalidException("La photo de lentreprise nest pas sauvegrdee", ErrorCodes.SAVED_PHOTO);
        }
       clientDTO.setPhoto(photo.toString());
        return    clientService.saveClient(clientDTO);
    }
}
