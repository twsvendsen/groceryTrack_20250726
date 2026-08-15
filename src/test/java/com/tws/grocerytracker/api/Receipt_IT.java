package com.tws.grocerytracker.api;

import com.tws.grocerytracker.app.Application;
import com.tws.grocerytracker.dto.GroceryItemDto;
import com.tws.grocerytracker.dto.ReceiptDto;
import com.tws.grocerytracker.service.ReceiptService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Locale;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class)
@AutoConfigureMockMvc
@WebAppConfiguration
public class Receipt_IT {

    @Autowired
    private MockMvc mvc;

    private ReceiptService receiptService;

    private ReceiptApi receiptApi;

    @Test
    public void testApp() {
        // given
        ReceiptDto receiptDto = new ReceiptDto();
        receiptDto.setAddress("123 fake street, Dorb City, ZZ 99999");
        receiptDto.setStoreName("Schmublix");
        GroceryItemDto groceryItemDto = new GroceryItemDto();
        groceryItemDto.setNameOfProduct("Gloreos");
        groceryItemDto.setCost(new BigDecimal(1));
        receiptDto.setGroceryItems(List.of(groceryItemDto));
        receiptDto.setSubtotalCost(new BigDecimal(1));
        receiptDto.setTotalCost(new BigDecimal(2));
        receiptDto.setTransactionDateTime(OffsetDateTime.now().toString());

        // when
        ResponseEntity<Void> responseEntity = receiptApi.createReceipt(Locale.US.toString(), receiptDto);

        // then
        // TODO: set up mockito
//        responseEntity.getStatusCode() == HttpStatus.OK;
    }
}
