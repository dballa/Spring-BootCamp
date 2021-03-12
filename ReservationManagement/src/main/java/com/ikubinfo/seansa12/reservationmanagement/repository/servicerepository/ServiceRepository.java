package com.ikubinfo.seansa12.reservationmanagement.repository.servicerepository;

import java.util.List;

import com.ikubinfo.seansa12.reservationmanagement.model.service.Services;

public interface ServiceRepository {
	
	Services save(Services service);

	Services update(Services service);

	boolean delete(String code);

	List<Services> getAll();

	Services findService(String name);

	boolean existServiceWithCode(String code);

}
