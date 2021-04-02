package com.academy.rest.service.implementation;

import com.academy.rest.entities.ArtistEntity;
import com.academy.rest.repository.ArtistRepo;
import com.academy.rest.request.ArtistRequestCreate;
import com.academy.rest.service.ArtistServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
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
        ArtistEntity artistEntity = getArtist(id);
        return artistRepo.deleteArtist(artistEntity);
    }

    @Override
    public List<ArtistEntity> getArtists() {
        return artistRepo.getArtists();
    }

    @Override
    public ArtistEntity getArtist(Long id) {
        return artistRepo.getArtist(id);
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
        return artistRepo.getArtistsWithNoOFAlbums(no);
    }
}
