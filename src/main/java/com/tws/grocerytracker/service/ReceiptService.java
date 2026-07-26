package com.tws.grocerytracker.service;

import com.tws.grocerytracker.dto.ReceiptDto;
import com.tws.grocerytracker.mapper.ReceiptMapper;
import com.tws.grocerytracker.model.GroceryItem;
import com.tws.grocerytracker.model.Receipt;
import com.tws.grocerytracker.model.StoreLocation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.tws.grocerytracker.repository.CommodityRepository;
import com.tws.grocerytracker.repository.ReceiptRepository;
import com.tws.grocerytracker.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReceiptService {

    private ReceiptMapper receiptMapper;
    private GroceryItemService groceryItemService;
    private StoreService storeService;
    private ReceiptRepository receiptRepository;
    private StoreRepository storeRepository;
    private CommodityRepository commodityRepository;

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
