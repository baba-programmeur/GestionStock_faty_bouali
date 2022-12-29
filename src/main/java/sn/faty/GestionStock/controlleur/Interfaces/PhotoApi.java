package sn.faty.gestionstock.controlleur.Interfaces;
import com.flickr4java.flickr.FlickrException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import static sn.faty.gestionstock.constants.Constants.APP_ROOT;

public interface PhotoApi {
    @PostMapping(value = APP_ROOT+"/addPhoto/{id}/{title}/{contexte}",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
     Object savePhoto(@PathVariable Long id, @RequestPart("file") MultipartFile photo, @PathVariable String title, @PathVariable  String contexte) throws FlickrException, IOException;

}