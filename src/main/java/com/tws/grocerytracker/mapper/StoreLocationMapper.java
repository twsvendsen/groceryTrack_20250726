package com.tws.grocerytracker.mapper;

import com.tws.grocerytracker.model.StoreLocation;

public class StoreLocationMapper {
    public StoreLocation mapStoreDetailsToNewStoreLocation(String storeName, String storeAddress) {
        StoreLocation storeLocation;
        storeLocation = new StoreLocation();
        storeLocation.setStoreName(storeName);
        storeLocation.setAddress(storeAddress);
        storeLocation.setNumberOfVisits(0);
        return storeLocation;
    }
}
