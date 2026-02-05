package com.tws.grocerytracker.service;

import com.tws.grocerytracker.dto.ReceiptDto;
import com.tws.grocerytracker.mapper.ReceiptMapper;
import com.tws.grocerytracker.model.GroceryItem;
import com.tws.grocerytracker.model.Receipt;
import com.tws.grocerytracker.model.StoreLocation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ReceiptRepository;
import repository.StoreRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReceiptService {

    private ReceiptMapper receiptMapper;
    private ReceiptRepository receiptRepository;
    private StoreRepository storeRepository;

    public void createReceipt(ReceiptDto receiptDto) {
        Optional<StoreLocation> storeLocation = storeRepository.findByStoreNameAndAddress(receiptDto.getStoreName(), receiptDto.getAddress());
        Receipt receipt = receiptMapper.mapReceiptDtoToReceipt(receiptDto, storeLocation);
        receiptRepository.save(receipt);
    }

    // update GroceryItem
    public void updateGroceryItem(GroceryItem groceryItem) {
        
    }
}
