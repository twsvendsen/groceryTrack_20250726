package com.tws.grocerytracker.api;

import com.tws.grocerytracker.dto.ReceiptDto;
import com.tws.grocerytracker.service.ReceiptService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/groceryTracker")
public class ReceiptApi {

    private ReceiptService receiptService;

    @RequestMapping(
            value = "/receipt",
            method = RequestMethod.POST
    )
    public ResponseEntity<Void> createReceipt(
//            @Pattern(regexp = "^[a-z]{3}-[A-Z]{3}$") @RequestHeader(value = "Locale", required = false) String locale,
            @Valid @RequestBody(required = false) ReceiptDto receiptDto
    ) {
        try {
            receiptService.createReceipt(receiptDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/example", method = RequestMethod.GET)
    public String handlePostRequest() {
        return "Handled POST request";
    }

}
