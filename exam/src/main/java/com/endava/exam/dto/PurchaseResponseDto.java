package com.endava.exam.dto;


import com.endava.exam.model.Item;
import com.endava.exam.model.Supermarket;
import com.endava.exam.model.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Set;

@Getter
@Setter
public class PurchaseResponseDto {

    private Supermarket supermarket;

    private Set<Item> items;

    private PaymentType paymentType;

    private Double cashAmount;


    private Double totalPrice;

    private Double change;
}
