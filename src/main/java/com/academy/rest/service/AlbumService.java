package com.academy.rest.service;

import com.academy.rest.dto.AlbumModel;
import com.academy.rest.entities.AlbumEntity;
import com.academy.rest.request.AlbumRequestForCreate;

import java.util.List;

public interface AlbumService {

     AlbumEntity addAlbum(AlbumRequestForCreate albumRequestForCreate);
     boolean deleteAlbum(long id);
     List<AlbumEntity> getALlAlbums();
     Object getAlbum(Long id);
     List<AlbumEntity> getAlbumsOfArtist(Long id);
     List<AlbumEntity> getAlbumsOfArtistSorted(Long id,String sort);
     AlbumModel getRandomAlbum();
     List<AlbumEntity> getAlbumsOfGenre(String genre);
}
