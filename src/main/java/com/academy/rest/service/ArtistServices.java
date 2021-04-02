package com.academy.rest.service;

import com.academy.rest.entities.ArtistEntity;
import com.academy.rest.request.ArtistRequestCreate;

import java.util.List;


public interface ArtistServices {
    ArtistEntity addArtist(ArtistRequestCreate artistEntity);
    ArtistEntity deleteArtist(long id);
    List<ArtistEntity> getArtists();
    ArtistEntity getArtist(Long id);
    List<ArtistEntity> getArtistsByAge(int age);
    List<ArtistEntity> getArtistsByAgeOrder(int age,String type);
    List<Object[]> getArtistsWithNoOfAlbums(Long no);
}
