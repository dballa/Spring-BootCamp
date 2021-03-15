package com.academy.monika.service.service.impl;

import com.academy.monika.service.customexception.CustomException;
import com.academy.monika.service.model.OfferedService;
import com.academy.monika.service.repository.impl.ServiceRepository;
import com.academy.monika.service.service.CustomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferedServiceImpl implements CustomService<OfferedService> {
    ServiceRepository serviceRepository;

    public OfferedServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public OfferedService get(String uuid) {
        if (!serviceRepository.serviceExists(uuid)) {
            throw new CustomException("Service not found!");
        }
        return serviceRepository.get(uuid);
    }

    @Override
    public List<OfferedService> getList() {
        return serviceRepository.getList();
    }

    @Override
    public OfferedService add(OfferedService obj) {
        if (serviceRepository.serviceExists(obj.getId())) {
            throw new CustomException("This service already exists!");
        }
        return serviceRepository.create(obj);
    }

    @Override
    public OfferedService update(String uuid, OfferedService updatedObj) {
        if (!serviceRepository.serviceExists(updatedObj.getId())) {
            throw new CustomException("Service not found!");
        }
        return serviceRepository.update(uuid, updatedObj);
    }

    @Override
    public OfferedService delete(String uuid) {
        if (!serviceRepository.serviceExists(uuid)) {
            throw new CustomException("Service not found!");
        }
        return serviceRepository.delete(uuid);
    }
}
