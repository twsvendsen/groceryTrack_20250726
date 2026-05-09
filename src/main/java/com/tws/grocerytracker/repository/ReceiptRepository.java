package com.tws.grocerytracker.repository;

import com.tws.grocerytracker.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
}
