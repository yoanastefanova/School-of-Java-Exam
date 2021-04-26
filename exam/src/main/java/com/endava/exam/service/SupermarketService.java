package com.endava.exam.service;

import com.endava.exam.dto.AdditionRequestDto;
import com.endava.exam.dto.CreateSupermarketRequestDto;
import com.endava.exam.model.Supermarket;

public interface SupermarketService {

    Supermarket createSupermarket(CreateSupermarketRequestDto createSupermarket);


    Supermarket addItemsToSupermarket(AdditionRequestDto additionRequestDto);


    Supermarket getSupermarketById(String uuid);
}