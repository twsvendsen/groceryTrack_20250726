package com.tws.grocerytracker.service;


import com.tws.grocerytracker.mapper.StoreLocationMapper;
import com.tws.grocerytracker.model.StoreLocation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.tws.grocerytracker.repository.StoreRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StoreService {

    private StoreRepository storeRepository;
    private StoreLocationMapper storeLocationMapper;

    public StoreLocation getOrCreateStoreLocationByNameAndAddress(String storeName, String storeAddress) {
        // TODO: may need to integrate address or store name normalization services
        Optional<StoreLocation> existingStoreLocation = storeRepository.findByStoreNameAndAddress(storeName, storeAddress);
        StoreLocation storeLocation;
        storeLocation = existingStoreLocation.orElseGet(() -> storeLocationMapper.mapStoreDetailsToNewStoreLocation(storeName, storeAddress));
        storeLocation.setNumberOfVisits(storeLocation.getNumberOfVisits() != null ? storeLocation.getNumberOfVisits() + 1 : 1);
        storeRepository.save(storeLocation);
        return storeLocation;
    }
}
