package com.academy.rest.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AlbumRequestForCreate {
    private String name;
    private String genre;
    private int releaseYear;
    private Long artistId;
}
