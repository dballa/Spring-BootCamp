package com.ikubinfo.reservation.service.impl;

import com.ikubinfo.reservation.exceptions.ShopServiceManagementException;
import com.ikubinfo.reservation.model.ShopService;
import com.ikubinfo.reservation.repository.ShopServiceRepo;
import com.ikubinfo.reservation.service.ShopServiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopServiceService {
    private ShopServiceRepo shopServiceRepo;

    public ShopServiceImpl(ShopServiceRepo repo){
        this.shopServiceRepo = repo;
    }

    @Override
    public ShopService addShopService(ShopService shopService) {
        if (shopServiceRepo.existsService(shopService.getType())){
            throw new ShopServiceManagementException("This service is already offered by the shop." +
                                                            "\nMaybe you want to update it");
        }
        return shopServiceRepo.addShopService(shopService);
    }

    @Override
    public List<ShopService> getAllServices() {
        return shopServiceRepo.getAllServices();
    }
}
