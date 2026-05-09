package com.tws.grocerytracker.repository;

import com.tws.grocerytracker.dto.GroceryItemDto;
import com.tws.grocerytracker.model.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommodityRepository extends JpaRepository<Commodity, Integer> {
    List<Commodity> findAllByNameOfProductIn(List<GroceryItemDto> inputGroceryItems);
}
