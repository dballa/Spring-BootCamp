package com.academy.rest.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ArtistRequestCreate {
    private String name;
    private int age;
}
