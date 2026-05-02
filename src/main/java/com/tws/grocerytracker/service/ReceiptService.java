package com.tws.grocerytracker.service;

import com.tws.grocerytracker.dto.ReceiptDto;
import com.tws.grocerytracker.mapper.ReceiptMapper;
import com.tws.grocerytracker.model.Commodity;
import com.tws.grocerytracker.model.GroceryItem;
import com.tws.grocerytracker.model.Receipt;
import com.tws.grocerytracker.model.StoreLocation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.CommodityRepository;
import repository.ReceiptRepository;
import repository.StoreRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceiptService {

    private ReceiptMapper receiptMapper;
    private StoreService storeService;
    private ReceiptRepository receiptRepository;
    private StoreRepository storeRepository;
    private CommodityRepository commodityRepository;

    public void createReceipt(ReceiptDto receiptDto) {
        StoreLocation storeLocation = storeService.getOrCreateStoreLocationByNameAndAddress(receiptDto.getStoreName(), receiptDto.getAddress());

        List<GroceryItem> groceryItems = mapGroceryItems(receiptDto.getGroceryItems());

        Receipt receipt = receiptMapper.mapReceiptDtoToReceipt(receiptDto, storeLocation, groceryItems);

        receiptRepository.save(receipt);
        // TODO: may need to integrate address or store name normalization services
    }

    private List<GroceryItem> mapGroceryItems(List<String> inputGroceryItems) {
        List<GroceryItem> receiptGroceryItems = new ArrayList<>();
        List<Commodity> commodities = new ArrayList<>();
        if(inputGroceryItems != null && !inputGroceryItems.isEmpty()) {
            commodities = commodityRepository.findAllByNameIn(inputGroceryItems);
        }
        return receiptGroceryItems;
    }

    // update GroceryItem; is this needed?
    public void updateGroceryItem(GroceryItem groceryItem) {
        
    }
}
