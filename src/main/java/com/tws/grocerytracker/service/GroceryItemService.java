package com.tws.grocerytracker.service;

import com.tws.grocerytracker.dto.GroceryItemDto;
import com.tws.grocerytracker.mapper.GroceryItemMapper;
import com.tws.grocerytracker.model.Commodity;
import com.tws.grocerytracker.model.GroceryItem;
import com.tws.grocerytracker.model.Receipt;
import com.tws.grocerytracker.model.StoreLocation;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.tws.grocerytracker.repository.CommodityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroceryItemService {

    private CommodityRepository commodityRepository;
    private GroceryItemMapper groceryItemMapper;

    public List<GroceryItem> buildGroceryItemList(List<GroceryItemDto> inputGroceryItems, Receipt receipt, StoreLocation storeLocation) {
        List<GroceryItem> groceryItems = new ArrayList<>();
        List<Commodity> commodities = new ArrayList<>();
        if(inputGroceryItems != null && !inputGroceryItems.isEmpty()) {
            commodities = commodityRepository.findAllByNameOfProductIn(inputGroceryItems);
        }
        for(GroceryItemDto inputGroceryItem : inputGroceryItems) {
            Commodity matchedCommodity = commodities.stream()
                    .filter(commodity ->
                            StringUtils.isNotEmpty(commodity.getItemName())
                                    && StringUtils.isNotEmpty(inputGroceryItem.getNameOfProduct())
                                    && commodity.getItemName().equals(inputGroceryItem.getNameOfProduct()))
                    .findFirst().orElse(null);
            GroceryItem groceryItem = groceryItemMapper.mapGroceryItemDtoToGroceryItem(inputGroceryItem, receipt, storeLocation, matchedCommodity);
            groceryItems.add(groceryItem);
        }
        return groceryItems;
    }
}
