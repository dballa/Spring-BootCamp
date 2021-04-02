package com.academy.rest.repository;

import com.academy.rest.entities.AlbumEntity;
import com.academy.rest.exceptions.AlbumNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AlbumRepo {

    @Autowired
    EntityManager entityManager ;

    private static final String GET_ALBUMS =  " select album from AlbumEntity album";
    private static final String GET_ALBUM_BY_ID = "select album from AlbumEntity album " +
            "where album.id = ?1";
    private static final String GET_ALBUMS_OF_ARTIST = "select album from AlbumEntity album " +
            " where album.artistEntity.id = ?1" ;
    private static String GET_ALBUMS_SORTED_BY_YEAR_ASC = "select album from AlbumEntity album " +
            " where album.artistEntity.id = ?1" +
            " order by album.releaseYear ASC";
    private static String GET_ALBUMS_SORTED_BY_YEAR_DESC = "select album from AlbumEntity album " +
            " where album.artistEntity.id = ?1" +
            " order by album.releaseYear DESC";
    private static final String GET_ALBUMS_OF_GENRE = "select album from AlbumEntity album " +
            " where album.genre = :genre" ;
    public void addAlbum(AlbumEntity albumEntity){
        entityManager.persist(albumEntity);
    }

    public List<AlbumEntity> getALlAlbums(){
        TypedQuery<AlbumEntity> albumEntityTypedQuery = entityManager.createQuery(GET_ALBUMS,AlbumEntity.class);
        return albumEntityTypedQuery.getResultList();
    }
    public AlbumEntity getAlbum(Long id) throws NoResultException, NonUniqueResultException {
        TypedQuery<AlbumEntity> albumEntityTypedQuery = entityManager.createQuery(GET_ALBUM_BY_ID,AlbumEntity.class)
                .setParameter(1,id);
        return  albumEntityTypedQuery.getSingleResult();
    }
    public List<AlbumEntity> getAlbumsOfArtist(Long id)  {
        TypedQuery<AlbumEntity> albumEntityTypedQuery = entityManager.createQuery(GET_ALBUMS_OF_ARTIST,AlbumEntity.class).setParameter(1,id);
        return albumEntityTypedQuery.getResultList();
    }
    public List<AlbumEntity> getAlbumsOfArtistSorted(Long id,String sort){
        TypedQuery<AlbumEntity> albumEntityTypedQuery ;
        if (sort.compareToIgnoreCase("desc")==0){
            albumEntityTypedQuery
                    = entityManager.createQuery(GET_ALBUMS_SORTED_BY_YEAR_DESC ,AlbumEntity.class)
                    .setParameter(1,id);
        } else {
            albumEntityTypedQuery =
                    entityManager.createQuery(GET_ALBUMS_SORTED_BY_YEAR_ASC ,AlbumEntity.class)
                            .setParameter(1,id);
        }

        return albumEntityTypedQuery.getResultList();
    }

    public List<AlbumEntity> getAlbumByGenre(String genre){
        TypedQuery<AlbumEntity> albumEntityTypedQuery =
                entityManager.createQuery(GET_ALBUMS_OF_GENRE,AlbumEntity.class)
                .setParameter("genre",genre);
        return albumEntityTypedQuery.getResultList();
    }
    public boolean deleteAlbum(AlbumEntity albumEntity){
        try{
            entityManager.remove(albumEntity);
            return true;
        } catch (IllegalArgumentException illegalArgumentException){
            return false;
        }

    }

}
