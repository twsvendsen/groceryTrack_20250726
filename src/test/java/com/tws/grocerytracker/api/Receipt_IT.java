package com.tws.grocerytracker.api;

import com.tws.grocerytracker.app.Schmapplication;
import com.tws.grocerytracker.dto.GroceryItemDto;
import com.tws.grocerytracker.dto.ReceiptDto;
import com.tws.grocerytracker.service.ReceiptService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Locale;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Schmapplication.class)
@AutoConfigureMockMvc
@WebAppConfiguration
public class Receipt_IT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ReceiptService receiptService;

    @Autowired
    private ReceiptApi receiptApi;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(receiptApi)
                .defaultRequest(get("/").accept(MediaType.APPLICATION_JSON))
                .alwaysExpect(status().isOk())
                .alwaysExpect(content().contentType("application/json;charset=UTF-8"))
                .build();
    }

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

//        String requestBody = Files.readString(Path.of(""));

        // when
        try {
            mockMvc.perform(multipart("/receipt").file("testReceipt", Files.readString(Path.of("src/test/resources/requests/testReceipt.xml")).getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            System.out.println(e.getCause().toString());
            fail("exception thrown");
        }
        ResponseEntity<Void> responseEntity = receiptApi.createReceipt(Locale.US.toString(), receiptDto);

        // then
//        responseEntity.getStatusCode() == HttpStatus.OK;
    }
}
