package com.endava.exam.service.impl;

import com.endava.exam.dto.AdditionRequestDto;
import com.endava.exam.dto.CreateSupermarketRequestDto;
import com.endava.exam.model.Item;
import com.endava.exam.model.Supermarket;
import com.endava.exam.repository.ItemRepository;
import com.endava.exam.repository.SupermarketRepository;
import com.endava.exam.service.SupermarketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupermarketServiceImpl implements SupermarketService {

    private final SupermarketRepository supermarketRepository;
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;


    @Override
    public Supermarket createSupermarket(CreateSupermarketRequestDto createSupermarket) {
        Supermarket newSupermarket = this.modelMapper.map(createSupermarket, Supermarket.class);
        return supermarketRepository.save(newSupermarket);
    }


    @Override
    public Supermarket addItemsToSupermarket(AdditionRequestDto additionRequest) {
        Supermarket supermarket = supermarketRepository.findSupermarketByUuid(additionRequest.getSupermarketId())
                .orElseThrow(() -> new EntityNotFoundException("Supermarket not found."));

        List<Item> items = supermarket.getItems();

        for (String itemId : additionRequest.getItemIds()) {
            Item item = this.itemRepository.findById(itemId).orElseThrow(() -> new EntityNotFoundException("Item not found!"));
            item.setSupermarket(supermarket);
            items.add(item);
        }

        supermarket.setItems(items);
        return supermarketRepository.saveAndFlush(supermarket);
    }

    @Override
    public Supermarket getSupermarketById(String id) {
        return this.supermarketRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("This supermarket is non-existent."));
    }
}
