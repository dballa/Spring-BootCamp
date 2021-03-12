package com.ikubinfo.reservation.repository;

import com.ikubinfo.reservation.model.ShopService;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ShopServiceRepo {
    ShopService addShopService(ShopService shopService);
    boolean existsService(String type);
    List<ShopService> getAllServices();
}
