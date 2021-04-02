package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.converter.PublisherConverter;
import com.book.dto.PublisherDto;
import com.book.dto.PublisherDtoForCreate;
import com.book.dto.PublisherDtoForUpdate;
import com.book.entity.BookEntity;
import com.book.entity.PublisherEntity;
import com.book.exception.PublisherException;
import com.book.repository.BookRepository;
import com.book.repository.PublisherRepository;

@Service
public class PublisherService {
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	PublisherRepository publisherRepository;
	
	public PublisherEntity addPublisher(PublisherDtoForCreate publisher) {
		if (publisher != null) {
			if (publisher.getName() != null) {
				if(publisher.getAddress() != null) {
				PublisherEntity publisherToAdd = PublisherConverter.toEntityForCreate(publisher);
				
				publisherRepository.addPublisher(publisherToAdd);
				return publisherToAdd;
				
				}else {
					System.out.println("Publisher address is mandatory");
					throw new PublisherException("Publisher address is required");
				}
			}else {
				System.out.println("Publisher name is mandatory");
				throw new PublisherException("Publisher Name is required");
			}
		}
		else {
			throw new PublisherException("Could not create publisher");
		}
	}
	
	public PublisherEntity deletePublisher(long id) {
		PublisherEntity publisher = publisherRepository.getPublisherById(id);
		if (publisher != null) {
				publisherRepository.deletePublisher(publisher);
				return publisher;
		} else {
			System.out.println("Publisher not found");
			throw new PublisherException("Publisher with id: " + id + ", does not exist");
		}
		
	}
	
	public PublisherDto updatePublisher(long id, PublisherDtoForUpdate publisher) {
		PublisherEntity publisherFromDb = publisherRepository.getPublisherById(id);
		if (publisherFromDb != null) {
			PublisherEntity updatePublisherEntity = PublisherConverter.toEntityForUpdate(publisher);
			updatePublisherEntity.setId(id);
			PublisherEntity response = publisherRepository.updatePublisher(updatePublisherEntity);
			
			return PublisherConverter.toDto(response);
		} else {
			System.out.println("Publisher not found");
			throw new PublisherException("Publisher with id: " + id + ", does not exist");
		}
	}
	
	public List<PublisherEntity> searchPublisherByName(String name) {
		return publisherRepository.searchByName(name);
	}
	
	public List<PublisherEntity> searchPublisherByAddress(String address) {
		return publisherRepository.searchByAddress(address);
	}
	
	public List<PublisherEntity> getAllPublisher(){
		return publisherRepository.getAllPublisher();
	}
	
	public PublisherEntity getPublisherById(long id) {
		return publisherRepository.getPublisherById(id);
	}
}


