package sn.faty.GestionStock.service.implementation;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sn.faty.GestionStock.service.Interface.FlickrServicePhoto;

import java.io.InputStream;

@Slf4j
@Service
public class FlickrServicePhotoImpl implements FlickrServicePhoto {

    private Flickr flickr ;
    @Autowired
    public FlickrServicePhotoImpl(Flickr flickr) {
        this.flickr = flickr;
    }

    @Override
    public String savePhoto(InputStream photo, String title) throws FlickrException {
        UploadMetaData uploadMetaData=new UploadMetaData();
        uploadMetaData.setTitle(title);
        String photoId= flickr.getUploader().upload(photo,uploadMetaData);
        return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
    }

    private  void  connect ()
    {
    }

}
