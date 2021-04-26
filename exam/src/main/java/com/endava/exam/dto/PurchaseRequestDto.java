package com.endava.exam.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
public class PurchaseRequestDto {

    @NotBlank(message = "Incorrect id")
    private String supermarketId;

    @NotEmpty(message = "Incorrect ids")
    private List<String> itemIds;

    @NotNull(message = "Non-existent type of payment")
    private String typeOfPayment;

    private Double cashAmount;
}
