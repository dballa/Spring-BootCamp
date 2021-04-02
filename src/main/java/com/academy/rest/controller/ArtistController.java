package com.academy.rest.controller;

import com.academy.rest.entities.ArtistEntity;
import com.academy.rest.request.ArtistRequestCreate;
import com.academy.rest.service.ArtistServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistServices artistServices;

    @ApiOperation("Add a new User")
    @PostMapping
    public ResponseEntity<ArtistEntity> addArtist(@RequestBody ArtistRequestCreate artistRequestCreate){
        return new ResponseEntity<>(artistServices.addArtist(artistRequestCreate),HttpStatus.FOUND);
    }

    @ApiOperation("Display all users")
    @GetMapping
    public ResponseEntity<List<ArtistEntity>> getArtist(){
        return new ResponseEntity<>(artistServices.getArtists(),HttpStatus.FOUND);
    }

    @ApiOperation("Delete a user")
    @DeleteMapping("/delete/{id}")

    public ResponseEntity<ArtistEntity> deleteArtist(@PathVariable Long id){

        return new ResponseEntity<>(artistServices.deleteArtist(id),HttpStatus.FOUND);
    }

    @ApiOperation("Find a user by id")
    @GetMapping("{id}")
    public ResponseEntity<ArtistEntity> getArtist(@PathVariable Long id){
        return new ResponseEntity<>(artistServices.getArtist(id),HttpStatus.FOUND);
    }

//    @ApiOperation("Get all artist younger than a certain age")
//    @GetMapping("/criteria")
//    public List<ArtistEntity> getArtistByAge(@RequestParam int age){
//        return artistServices.getArtistsByAge(age);
//    }
    @ApiOperation("Get all artist younger than a certain age ordered")
    @GetMapping("/criteria")
    public ResponseEntity<List<ArtistEntity>> getArtistByAgeOrdered(@RequestParam int age , @RequestParam String orderBy){
        return new ResponseEntity<>(artistServices.getArtistsByAgeOrder(age,orderBy),HttpStatus.FOUND);
    }

    @ApiOperation("Get all artist having at least a specified number of albums")
    @GetMapping("/criteria/albums")
    public ResponseEntity<List<Object[]>> getArtistNoAlbums(@RequestParam Long noAlbums){
        return new ResponseEntity<>(artistServices.getArtistsWithNoOfAlbums(noAlbums),HttpStatus.FOUND);
    }

}
