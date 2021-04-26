package com.endava.exam.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AdditionResponseDto {

    private String supermarketId;

    private List<String> itemName;
}
