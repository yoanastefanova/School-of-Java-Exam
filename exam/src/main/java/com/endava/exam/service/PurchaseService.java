package com.endava.exam.service;

import com.endava.exam.dto.PurchaseRequestDto;
import com.endava.exam.model.Purchase;

import java.util.List;

public interface PurchaseService {
    Purchase buyItemsFromSupermarket(PurchaseRequestDto buyItemsRequestDto);

    List<Purchase> getAllPurchases(String pageNumber, String pageSize, String sortBy);

}
