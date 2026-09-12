package com.tws.grocerytracker.service;


import com.tws.grocerytracker.mapper.StoreLocationMapper;
import com.tws.grocerytracker.model.StoreLocation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.tws.grocerytracker.repository.StoreRepository;
import com.smartystreets.api.us_street.*;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StoreService {

    private StoreRepository storeRepository;
    private StoreLocationMapper storeLocationMapper;
    private SmartyRemoteAgent smartyRemoteAgent;

    public StoreLocation getOrCreateStoreLocationByNameAndAddress(String storeName, String streetAddress, String location) throws Exception {
        // TODO: implement Smarty address normalization API
        Candidate normalizedStoreAddress;
        try {
            normalizedStoreAddress = normalizeStoreAddress(streetAddress, location);
        } catch (Exception ex) {
            // TODO: propagate exception
            throw new Exception("Address normalization failure");
        }

        Optional<StoreLocation> existingStoreLocation = storeRepository.findByStoreNameAndZipcode(storeName, normalizedStoreAddress.getComponents().getZipCode());
        StoreLocation storeLocation;
        storeLocation = existingStoreLocation.orElseGet(() -> storeLocationMapper.mapStoreDetailsToNewStoreLocation(storeName, normalizedStoreAddress.getDeliveryLine1(), normalizedStoreAddress.getComponents().getCityName(), normalizedStoreAddress.getComponents().getState(), normalizedStoreAddress.getComponents().getZipCode()));
        storeLocation.setNumberOfVisits(storeLocation.getNumberOfVisits() != null ? storeLocation.getNumberOfVisits() + 1 : 1);
        storeRepository.save(storeLocation);
        return storeLocation;
    }

    private Candidate normalizeStoreAddress(String streetAddress, String location) throws Exception {
        Candidate normalizedStoreAddress;
        try {
            normalizedStoreAddress = smartyRemoteAgent.lookUpAddress(streetAddress, location);
        } catch (Exception ex) {
            // TODO: propagate exception
            throw new Exception("Address normalization failure");
        }
        return normalizedStoreAddress;
    }
}
