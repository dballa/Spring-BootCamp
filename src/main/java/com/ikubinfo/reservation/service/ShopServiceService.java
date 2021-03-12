package com.ikubinfo.reservation.service;

import com.ikubinfo.reservation.model.ShopService;

import java.util.List;

public interface ShopServiceService {
    ShopService addShopService(ShopService shopService);
    List<ShopService> getAllServices();
}
