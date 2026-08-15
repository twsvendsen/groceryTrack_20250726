package com.tws.grocerytracker.repository;

import com.tws.grocerytracker.model.StoreLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<StoreLocation, Integer> {
    Optional<StoreLocation> findByStoreNameAndAddress(String storeName, String address);

}
