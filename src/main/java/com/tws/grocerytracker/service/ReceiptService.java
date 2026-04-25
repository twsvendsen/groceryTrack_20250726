package com.tws.grocerytracker.service;

import com.tws.grocerytracker.dto.ReceiptDto;
import com.tws.grocerytracker.mapper.ReceiptMapper;
import com.tws.grocerytracker.model.Commodity;
import com.tws.grocerytracker.model.GroceryItem;
import com.tws.grocerytracker.model.Receipt;
import com.tws.grocerytracker.model.StoreLocation;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.CommodityRepository;
import repository.ReceiptRepository;
import repository.StoreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReceiptService {

    private ReceiptMapper receiptMapper;
    private ReceiptRepository receiptRepository;
    private StoreRepository storeRepository;
    private CommodityRepository commodityRepository;

    public void createReceipt(ReceiptDto receiptDto) {
        Optional<StoreLocation> existingStoreLocation = storeRepository.findByStoreNameAndAddress(receiptDto.getStoreName(), receiptDto.getAddress());
        StoreLocation storeLocation;
        if(existingStoreLocation.isEmpty()) {
            storeLocation = new StoreLocation();
            storeLocation.setStoreName(receiptDto.getStoreName());
            storeLocation.setAddress(receiptDto.getAddress());
            storeRepository.save(storeLocation);
        } else {
            storeLocation = existingStoreLocation.get();
        }

        List<GroceryItem> groceryItems = mapGroceryItems(receiptDto.getGroceryItems());

        Receipt receipt = receiptMapper.mapReceiptDtoToReceipt(receiptDto, storeLocation, groceryItems);

        receiptRepository.save(receipt);
        // TODO: may need to integrate address or store name normalization services
    }

    private List<GroceryItem> mapGroceryItems(List<String> inputGroceryItems) {
        List<GroceryItem> receiptGroceryItems = new ArrayList<>();
        if(inputGroceryItems != null && !inputGroceryItems.isEmpty()) {
            receiptGroceryItems = commodityRepository.findAllByNameIn(inputGroceryItems);
        }
        return receiptGroceryItems;
    }

    // update GroceryItem; is this needed?
    public void updateGroceryItem(GroceryItem groceryItem) {
        
    }
}
