package com.endava.exam.dto;

import com.endava.exam.model.Item;
import com.endava.exam.model.Supermarket;
import com.endava.exam.model.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BoughtItemsResponseDto {

    private Supermarket supermarket;

    private Set<Item> items;

    private PaymentType paymentType;

    private Double cashAmount;

    private Double totalPrice;

    private Double changeAmount;

}
