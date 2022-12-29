package sn.faty.gestionstock.service.Interface;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface FlickrServicePhoto {

  String savePhoto(InputStream photo ,String title) throws FlickrException;
}
