package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.converter.PublisherConverter;
import com.book.dto.PublisherDto;
import com.book.dto.PublisherDtoForCreate;
import com.book.entity.PublisherEntity;
import com.book.service.PublisherService;


@RestController
public class PublisherController {
	@Autowired
	PublisherService publisherService;

	@GetMapping("/publisher")
	public List<PublisherEntity> getAll(@RequestParam(required=false) String name, @RequestParam(required=false) String address){
		
		if(name != null && address != null) {
			return publisherService.getAllPublisher();
		}
		
		if(name != null) {
			return publisherService.searchPublisherByName(name);
		}
		if(address != null) {
			return publisherService.searchPublisherByAddress(address);
		}
		
		return publisherService.getAllPublisher();
	}
	
	@GetMapping("/publisher/{id}")
	public PublisherEntity getById(@PathVariable long id) {
		PublisherEntity entity = publisherService.getPublisherById(id);
		return entity;
	}
	
	@DeleteMapping("/publisher/{id}")
	public PublisherEntity deletePublisher(@PathVariable long id) {
		return publisherService.deletePublisher(id);
	}

	@PostMapping("/publisher")
	public PublisherDto addPublisher(@RequestBody PublisherDtoForCreate publisher) {
		PublisherEntity publisherEntity = publisherService.addPublisher(publisher);
		return PublisherConverter.toDto(publisherEntity);
	}
}
