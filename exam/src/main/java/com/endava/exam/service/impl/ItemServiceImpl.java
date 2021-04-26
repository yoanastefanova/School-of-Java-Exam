package com.endava.exam.service.impl;


import com.endava.exam.dto.CreateItemRequestDto;
import com.endava.exam.model.Item;
import com.endava.exam.repository.ItemRepository;
import com.endava.exam.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;


    @Override
    public Item createItem(CreateItemRequestDto createItem) {
        Item newItem = this.modelMapper.map(createItem, Item.class);
        return itemRepository.save(newItem);
    }
}
