package com.academy.monika.service;

import com.academy.monika.service.model.OfferedService;
import com.academy.monika.service.model.User;
import com.academy.monika.service.repository.impl.ServiceRepository;
import com.academy.monika.service.repository.impl.UserRepository;
import com.academy.monika.service.service.impl.OfferedServiceImpl;
import com.academy.monika.service.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ServiceTest {
    private OfferedServiceImpl offeredService;
    private ServiceRepository serviceRepository;

    @BeforeEach
    public void beforeEachMethod() {
        serviceRepository = Mockito.mock(ServiceRepository.class);
        offeredService = new OfferedServiceImpl(serviceRepository);
    }

    @Test
    void serviceCreatedSuccessfullyTest() {

        OfferedService service = new OfferedService();
        service.setId("111");
        service.setName("Service Name");
        service.setPrice(15);
        when(serviceRepository.create(service)).thenReturn(service);
        assertEquals(service, offeredService.add(service));
    }

}
