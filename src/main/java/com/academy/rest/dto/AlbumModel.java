package com.academy.rest.dto;

import com.academy.rest.entities.ArtistEntity;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlbumModel {

    private Long id;

    private String name;

    private String genre;

    private int releaseYear;

    //private int artistId;
}
