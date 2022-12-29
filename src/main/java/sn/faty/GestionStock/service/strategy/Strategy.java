package sn.faty.gestionstock.service.strategy;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface Strategy<T> {

    T savePhoto(Long id, InputStream photo,String title) throws FlickrException;
}
