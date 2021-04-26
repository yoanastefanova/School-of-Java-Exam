package com.endava.exam.service;

import com.endava.exam.dto.CreateItemRequestDto;
import com.endava.exam.model.Item;

public interface ItemService {

    Item createItem(CreateItemRequestDto createItem);

}
