package com.tws.grocerytracker.service;

import com.tws.grocerytracker.dto.ReceiptDto;
import com.tws.grocerytracker.mapper.ReceiptMapper;
import com.tws.grocerytracker.model.GroceryItem;
import com.tws.grocerytracker.model.Receipt;
import com.tws.grocerytracker.model.StoreLocation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.tws.grocerytracker.repository.ReceiptRepository;

@Service
@AllArgsConstructor
public class ReceiptService {

    private ReceiptMapper receiptMapper;
    private GroceryItemService groceryItemService;
    private StoreService storeService;
    private ReceiptRepository receiptRepository;

    public void createReceipt(ReceiptDto receiptDto) {
        StoreLocation storeLocation = storeService.getOrCreateStoreLocationByNameAndAddress(receiptDto.getStoreName(), receiptDto.getAddress());

        Receipt receipt = receiptMapper.mapReceiptDtoToReceipt(receiptDto, storeLocation);
        groceryItemService.buildAndMapGroceryItemList(receiptDto.getGroceryItems(), receipt, storeLocation);

        receiptRepository.save(receipt);
    }

    // update GroceryItem; is this needed?
    public void updateGroceryItem(GroceryItem groceryItem) {
        
    }
}
