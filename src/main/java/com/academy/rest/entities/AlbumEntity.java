package com.academy.rest.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="album")
public class AlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String genre;

    @Column
    private int releaseYear;

    @ManyToOne
        @JoinColumn(name = "artist_id" , referencedColumnName = "id")
    private ArtistEntity artistEntity;
}
