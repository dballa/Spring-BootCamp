package com.academy.rest.converter;

import com.academy.rest.dto.ArtistModel;
import com.academy.rest.entities.ArtistEntity;

public class ArtistConverter {

    public static ArtistEntity toArtistEntity(ArtistModel artistModel){
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setName(artistModel.getName());
        artistEntity.setAge(artistModel.getAge());
        artistEntity.setId(artistModel.getId());
        return artistEntity;
    }
}
