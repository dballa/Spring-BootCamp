package com.academy.rest.controller;

import com.academy.rest.entities.AlbumEntity;
import com.academy.rest.request.AlbumRequestForCreate;
import com.academy.rest.service.AlbumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @ApiOperation("Add a new album")
    @PostMapping
    public ResponseEntity<AlbumEntity> addAlbum(@RequestBody AlbumRequestForCreate albumRequestForCreate){
        return new ResponseEntity<>(albumService.addAlbum(albumRequestForCreate),HttpStatus.OK);
    }

    @ApiOperation("Display all albums")
    @GetMapping
    public ResponseEntity<List<AlbumEntity>> getAlbums(){
        return new ResponseEntity<List<AlbumEntity>>(albumService.getALlAlbums(),HttpStatus.FOUND);
    }

    @ApiOperation("Display an album by id")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getAlbums(@PathVariable long id){
        return new ResponseEntity<>(albumService.getAlbum(id),HttpStatus.FOUND);
    }

    @ApiOperation("Delete an album")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object>  deleteAlbum(@PathVariable long id){
        return new ResponseEntity<>(albumService.deleteAlbum(id),HttpStatus.FOUND);
    }

    @ApiOperation("Display the albums of an artist providing the id")
    @GetMapping("/artist")
    public ResponseEntity<List<AlbumEntity>> getAlbumsOfArtist(@RequestParam long id){
        return new ResponseEntity<>(albumService.getAlbumsOfArtist(id),HttpStatus.FOUND);
    }

    @ApiOperation("Display the albums in sorted order of an artist providing the id and the order")
    @GetMapping("/artist/order")
    public ResponseEntity<List<AlbumEntity>> getAlbumsOfArtist(@RequestParam long id,@RequestParam String orderBy){
        return new ResponseEntity<>(albumService.getAlbumsOfArtistSorted(id,orderBy),HttpStatus.FOUND);
    }
}
