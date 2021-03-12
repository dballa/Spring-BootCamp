package com.ikubinfo.reservation.repository.impl;


import com.ikubinfo.reservation.model.ShopService;
import com.ikubinfo.reservation.repository.ShopServiceRepo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShopServiceRepoImpl implements ShopServiceRepo {

    private List<ShopService> shopServiceList = new ArrayList<>();

    @Override
    public ShopService addShopService(ShopService shopService) {
        shopServiceList.add(shopService);
        return shopService;
    }

    @Override
    public boolean existsService(String type) {
        for (ShopService sService : shopServiceList){
            if (sService.getType().compareTo(type)==0){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ShopService> getAllServices() {
        return shopServiceList;
    }
}
