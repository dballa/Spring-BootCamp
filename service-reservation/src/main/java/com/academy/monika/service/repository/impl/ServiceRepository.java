package com.academy.monika.service.repository.impl;

import com.academy.monika.service.model.OfferedService;
import com.academy.monika.service.repository.CustomRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ServiceRepository implements CustomRepository<OfferedService> {
    List<OfferedService> offeredServiceList = new ArrayList<>();

    @Override
    public OfferedService get(String uuid) {
        for (OfferedService offeredService : offeredServiceList) {
            if (uuid.equals(offeredService.getId())) {
                return offeredService;
            }
        }
        return null;
    }

    @Override
    public List<OfferedService> getList() {
        return offeredServiceList;
    }

    @Override
    public OfferedService create(OfferedService obj) {
        offeredServiceList.add(obj);
        return obj;
    }

    @Override
    public OfferedService update(String uuid, OfferedService updatedObj) {
        for (OfferedService offeredService : offeredServiceList) {
            if (uuid.equals(offeredService.getId())) {
                offeredService.setName(updatedObj.getName());
                offeredService.setPrice(updatedObj.getPrice());
                return offeredService;
            }
        }
        return null;
    }

    @Override
    public OfferedService delete(String uuid) {
        for (OfferedService offeredService : offeredServiceList) {
            if (uuid.equals(offeredService.getId())) {
                offeredServiceList.remove(offeredService);
            }
        }
        return null;
    }

    public Boolean serviceExists(String uuid) {
        for (OfferedService offeredService : offeredServiceList) {
            if (uuid.equals(offeredService.getId())) {
                return true;
            }
        }
        return false;
    }
}
