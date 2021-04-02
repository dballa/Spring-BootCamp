package com.academy.rest.repository;

import com.academy.rest.entities.ArtistEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArtistRepo {

    @Autowired
    private EntityManager entityManager;

    private final static String GET_ARTISTS = "select artist from ArtistEntity artist";
    private final static String GET_ARTIST = "select artist from ArtistEntity artist where id=?1";
    private final static String GET_ARTIST_AGE_CRITERIUM =
            "select artist from ArtistEntity artist where artist.age<?1";

    private final static String GET_ARTIST_AGE_CRITERIUM_ASC =
            "select artist from ArtistEntity artist where artist.age<?1 " +
                    "order by artist.age ASC";
    private final static String GET_ARTIST_AGE_CRITERIUM_DESC =
            "select artist from ArtistEntity artist " +
                    "where artist.age<?1" +
                    " order by artist.age DESC ";
    private final static String GET_ARTISTS_No_ALBUM_CRITERIUM =
            "select artist,COUNT(alb.id) as number from AlbumEntity alb  " +
                    " JOIN alb.artistEntity artist" +
                    " group by artist.id" +
                    " having COUNT(alb.id) >= ?1";
    public ArtistEntity addArtist(ArtistEntity artistEntity){
        entityManager.persist(artistEntity);
        return artistEntity;
    }

    public ArtistEntity deleteArtist(ArtistEntity artistEntity){
        entityManager.remove(artistEntity);
        return artistEntity;
    }
    public List<ArtistEntity> getArtists(){
        TypedQuery<ArtistEntity> allArtists = entityManager.createQuery(
                GET_ARTISTS,ArtistEntity.class
        );
        return allArtists.getResultList();
    }
    public ArtistEntity getArtist(Long id){
        TypedQuery<ArtistEntity> allArtist = entityManager.createQuery(
                GET_ARTIST,ArtistEntity.class
        ).setParameter(1,id);
        try{
            return allArtist.getSingleResult();
        } catch (NoResultException e){
            return null;
        }

    }
    public List<ArtistEntity> getArtistByAge(int age){
        TypedQuery<ArtistEntity> allArtist = entityManager.createQuery(
                GET_ARTIST_AGE_CRITERIUM,ArtistEntity.class
        ).setParameter(1,age);
        return allArtist.getResultList();
    }
    //for multiple return
    public List<Object[]> getArtistsWithNoOFAlbums(Long no){
        TypedQuery<Object[]> getArtists  =
                entityManager.createQuery(GET_ARTISTS_No_ALBUM_CRITERIUM,Object[].class)
                .setParameter(1,no);
        return getArtists.getResultList();
    }
    public List<ArtistEntity> getArtistByAgeOrdering(int age,String type){
        TypedQuery<ArtistEntity> allArtist;
        if (type.compareToIgnoreCase("desc")==0) {
            allArtist = entityManager.createQuery(
                    GET_ARTIST_AGE_CRITERIUM_DESC,ArtistEntity.class
            ).setParameter(1,age);

        } else {
            allArtist = entityManager.createQuery(
                    GET_ARTIST_AGE_CRITERIUM_ASC,ArtistEntity.class
            ).setParameter(1,age);

        }
        return allArtist.getResultList();
    }
}
