package com.tws.grocerytracker.repository;

import com.tws.grocerytracker.dto.GroceryItemDto;
import com.tws.grocerytracker.model.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity, Integer> {
    List<Commodity> findAllByNameIn(List<String> inputGroceryItems);
}
