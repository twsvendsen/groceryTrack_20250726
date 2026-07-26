package com.tws.grocerytracker.repository;

import com.tws.grocerytracker.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Integer> {
}
