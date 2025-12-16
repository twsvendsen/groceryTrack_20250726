package com.tws.grocerytracker.service;

import com.tws.grocerytracker.dao.ReceiptDao;
import com.tws.grocerytracker.dto.ReceiptDto;
import com.tws.grocerytracker.mapper.ReceiptMapper;
import com.tws.grocerytracker.model.GroceryItem;
import com.tws.grocerytracker.model.Receipt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiptService {

    private ReceiptMapper receiptMapper;
    private ReceiptDao receiptDao;

    public void createReceipt(ReceiptDto receiptDto) {
        Receipt receipt = receiptMapper.mapReceiptDtoToReceipt(receiptDto);
        receiptDao.catalogueReceipt(receipt);
    }

    // update GroceryItem
    public void updateGroceryItem(GroceryItem groceryItem) {
        
    }
}
