package com.endava.exam.service.impl;


import com.endava.exam.dto.PurchaseRequestDto;

import com.endava.exam.model.Item;
import com.endava.exam.model.Purchase;
import com.endava.exam.model.enums.PaymentType;
import com.endava.exam.repository.ItemRepository;
import com.endava.exam.repository.PurchaseRepository;
import com.endava.exam.repository.SupermarketRepository;
import com.endava.exam.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final SupermarketRepository supermarketRepository;
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    @Override
    public Purchase buyItemsFromSupermarket(PurchaseRequestDto purchaseRequestDto) {
        Purchase purchase;
        Double totalPrice = 0.0;

        try {
            PaymentType.valueOf(purchaseRequestDto.getTypeOfPayment());
        } catch (Exception exception) {
            throw new IllegalArgumentException("Cannot find payment method.");
        }

        if (PaymentType.valueOf(purchaseRequestDto.getTypeOfPayment()).equals(PaymentType.CASH) && purchaseRequestDto.getCashAmount() == null) {
            throw new IllegalArgumentException("Invalid amount");
        }

        purchase = modelMapper.map(purchaseRequestDto, Purchase.class);
        purchase.setSupermarket(supermarketRepository.findById(purchaseRequestDto.getSupermarketId()).orElseThrow(() -> new EntityNotFoundException("Non-existent supermarket")));
        purchase.setItems(purchaseRequestDto.getItemIds().stream().map(id -> itemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Non-existent item"))).collect(Collectors.toSet()));
        for (Item item : purchase.getItems()) {
            totalPrice += item.getPrice();
        }
        purchase.setTotalPrice(totalPrice);
        purchase.setChange(Double.parseDouble("0"));

        if (PaymentType.valueOf(purchaseRequestDto.getTypeOfPayment()).equals(PaymentType.CASH)) {
            purchase.setChange(purchase.getCashAmount() - totalPrice);
        }

        return purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> getAllPurchases(String pageNumber, String pageSize, String sortBy) {
        if (!(sortBy.equals("id") || sortBy.equals("totalPrice") || sortBy.equals("cash") || sortBy.equals("timeOfPayme"))) {
            throw new IllegalArgumentException("No such sorting category!");
        }

        Pageable paging = PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), Sort.by(sortBy));
        return this.purchaseRepository
                .findAll(paging)
                .stream()
                .collect(Collectors.toList());
    }
}