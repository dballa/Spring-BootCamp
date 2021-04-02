package com.academy.rest.service.implementation;

import com.academy.rest.converter.ArtistConverter;
import com.academy.rest.dto.AlbumModel;
import com.academy.rest.dto.ArtistModel;
import com.academy.rest.entities.AlbumEntity;
import com.academy.rest.exceptions.AlbumNotFoundException;
import com.academy.rest.exceptions.ArtistNotFoundException;
import com.academy.rest.repository.AlbumRepo;
import com.academy.rest.request.AlbumRequestForCreate;
import com.academy.rest.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import com.academy.rest.utils.Error;

@Service
@Transactional
public class AlbumServiceImplementation implements AlbumService {
    @Autowired
    AlbumRepo albumRepo;
    private final String URL = "http://localhost:8080/artist/";
    private final String URL_ALBUM = "http://localhost:8080/album/";

    @Override
    public AlbumEntity addAlbum(AlbumRequestForCreate albumRequestForCreate) {
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setName(albumRequestForCreate.getName());
        albumEntity.setGenre(albumRequestForCreate.getGenre());
        albumEntity.setReleaseYear(albumRequestForCreate.getReleaseYear());
        RestTemplate restTemplate = new RestTemplate();
        // + id e artistit
        ArtistModel artistModel
                = restTemplate.getForObject(URL+albumRequestForCreate.getArtistId(),ArtistModel.class);

        assert artistModel != null;
        if (!artistModel.isEmpty()){
            albumEntity.setArtistEntity(ArtistConverter.toArtistEntity(artistModel));
        }
        albumRepo.addAlbum(albumEntity);
        return albumEntity;
    }

    @Override
    public boolean deleteAlbum(long id) {
        RestTemplate restTemplate = new RestTemplate();
        try{
            AlbumEntity albumEntity = restTemplate.getForObject(URL_ALBUM+id,AlbumEntity.class);
            return albumRepo.deleteAlbum(albumEntity);
        } catch (RestClientException e){
            System.err.println("Could not delete");
            return false;
        }
    }

    @Override
    public List<AlbumEntity> getALlAlbums() {
        return albumRepo.getALlAlbums();
    }

    @Override
    public Object getAlbum(Long id) throws NoResultException, NonUniqueResultException {
        try{
            return albumRepo.getAlbum(id);
        }
        catch (NoResultException noResultException){
            //throw new AlbumNotFoundException("Album not found...");
            return new Error("Album wasn't found", LocalDateTime.now(),"Try adding the album you are looking for again in the repo");
        } catch (NonUniqueResultException e){
            return new Error("The provided id is ambiguous...!", LocalDateTime.now(),"Try contacting the db manager to delete one or more instances of this object");
        }
    }

    @Override
    public List<AlbumEntity> getAlbumsOfArtist(Long id) {
        List<AlbumEntity> albums = albumRepo.getAlbumsOfArtist(id);
        if (albums.isEmpty()){
           throw new ArtistNotFoundException("The albums of the request artist aren't yet in the database \n or the artist does not exist");
        }
        return albums;
    }

    @Override
    public List<AlbumEntity> getAlbumsOfArtistSorted(Long id, String sort) {
        if (sort.compareToIgnoreCase("desc")==0){
            List<AlbumEntity> albumEntities = albumRepo.getAlbumsOfArtistSorted(id,"DESC");
            if (albumEntities.isEmpty()){
                throw new ArtistNotFoundException("The provided artist doesn't have any albums or doesn not exist");
            }
            return albumEntities;
        } else if (sort.compareToIgnoreCase("asc")==0){
            List<AlbumEntity> albumEntities = albumRepo.getAlbumsOfArtistSorted(id,"ASC");
            if (albumEntities.isEmpty()){
                throw new ArtistNotFoundException("The provided artist doesn't have any albums or doesn not exist");
            }
            return albumEntities;
        }
        throw new IllegalArgumentException("The provided argument in the url is not valid");
    }
    @Override
    public AlbumModel getRandomAlbum(){
       RestTemplate restTemplate = new RestTemplate();
       AlbumModel[] albumModels =
               restTemplate.getForObject("https://api.mocki.io/v1/bb578855",
                       AlbumModel[].class);
       int i = (int)(Math.random()*albumModels.length);
//       System.out.println(albumModels[1]);
//       System.out.println(i);
       return albumModels[i];
   }

    @Override
    public List<AlbumEntity> getAlbumsOfGenre(String genre) {
        List<AlbumEntity> albumEntities = albumRepo.getAlbumByGenre(genre);
        if (albumEntities.isEmpty()){
            throw new AlbumNotFoundException(" Albums of this genre weren't found \n try again please");
        }
        return albumEntities;
    }

}
