package com.academy.rest.service.implementation;

import com.academy.rest.entities.ArtistEntity;
import com.academy.rest.exceptions.ArtistNotFoundException;
import com.academy.rest.repository.ArtistRepo;
import com.academy.rest.request.ArtistRequestCreate;
import com.academy.rest.service.ArtistServices;
import com.academy.rest.utils.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ArtistServiceImplementation implements ArtistServices {

    @Autowired
    ArtistRepo artistRepo;

    @Override
    public ArtistEntity addArtist(ArtistRequestCreate artistRequestCreate) {
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setName(artistRequestCreate.getName());
        artistEntity.setAge(artistRequestCreate.getAge());
        try{
            return artistRepo.addArtist(artistEntity);
        } catch (EntityExistsException e){
            System.out.println("This entity already exists...");
            return null;
        }

    }

    @Override
    public ArtistEntity deleteArtist(long id) {
        try{
            ArtistEntity artistEntity = getArtist(id);
            return artistRepo.deleteArtist(artistEntity);
        } catch (ArtistNotFoundException e){
            return null;
        }


    }

    @Override
    public List<ArtistEntity> getArtists() {
        return artistRepo.getArtists();
    }

    @Override
    public ArtistEntity getArtist(Long id) {
        ArtistEntity artistEntity = artistRepo.getArtist(id);
        if (artistEntity==null)
            throw new ArtistNotFoundException("The artist with the given ID wasn't found in our database");
        return artistEntity;


    }

    @Override
    public List<ArtistEntity> getArtistsByAge(int age) {
        return artistRepo.getArtistByAge(age);
    }

    @Override
    public List<ArtistEntity> getArtistsByAgeOrder(int age, String type) {
        return artistRepo.getArtistByAgeOrdering(age,type);
    }

//    @Override
//    public List<ArtistEntity> getArtistsByAgeAsc(int age) {
//        return artistRepo.getArtistByAgeOrdering(age,"asc");
//    }


    @Override
    public List<Object[]> getArtistsWithNoOfAlbums(Long no) {
        List<Object[]> artistEntities = artistRepo.getArtistsWithNoOFAlbums(no);
        if (artistEntities.isEmpty()){
            throw new ArtistNotFoundException(" Artist with such number of albums cannot be found ");
        }
        return artistEntities;



    }
}
