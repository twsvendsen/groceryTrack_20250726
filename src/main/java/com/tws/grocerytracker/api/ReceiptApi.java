package com.tws.grocerytracker.api;

import com.tws.grocerytracker.dto.ReceiptDto;
import com.tws.grocerytracker.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Component
@RequiredArgsConstructor
public class ReceiptApi {

    private ReceiptService receiptService;

    @RequestMapping(
            method = RequestMethod.POST
    )
    public ResponseEntity<Void> createReceipt(
            @Pattern(regexp = "^[a-z]{3}-[A-Z]{3}$") @RequestHeader(value = "Locale", required = false) @Nullable String locale,
            @Valid @RequestBody(required = false) @Nullable ReceiptDto receiptDto
    ) {
        receiptService.createReceipt(receiptDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
