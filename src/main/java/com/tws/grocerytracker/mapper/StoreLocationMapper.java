package com.tws.grocerytracker.mapper;

import com.tws.grocerytracker.model.StoreLocation;
import org.springframework.stereotype.Service;

@Service
public class StoreLocationMapper {
    public StoreLocation mapStoreDetailsToNewStoreLocation(String storeName, String streetAddress, String city, String state, String zipcode) {
        StoreLocation storeLocation;
        storeLocation = new StoreLocation();
        storeLocation.setStoreName(storeName);
        storeLocation.setStreetAddress(streetAddress);
        storeLocation.setCity(city);
        storeLocation.setState(state);
        storeLocation.setZipcode(Integer.parseInt(zipcode));
        storeLocation.setNumberOfVisits(0);
        return storeLocation;
    }
}
