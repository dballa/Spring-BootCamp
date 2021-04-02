package com.academy.rest.dto;


import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ArtistModel {
    private long id;
    private String name;
    private int age;

    public boolean isEmpty(){
        return id==0L;
    }
}
