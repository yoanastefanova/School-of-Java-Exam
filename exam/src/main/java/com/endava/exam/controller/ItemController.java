package com.endava.exam.controller;


import com.endava.exam.dto.CreateItemRequestDto;
import com.endava.exam.dto.ItemResponseDto;
import com.endava.exam.model.enums.ItemType;
import com.endava.exam.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/a1/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final ModelMapper modelMapper;

    @PostMapping(value="/create-item", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemResponseDto> createItem(@Valid @RequestBody CreateItemRequestDto dto, HttpServletResponse response){
        return new ResponseEntity ((modelMapper.map(itemService.createItem(dto), ItemResponseDto.class)), HttpStatus.CREATED);
    }


//    (@Valid @RequestParam(value="name") String name,
//    @Valid @RequestParam(value="price") Double price,
//    @RequestParam(value="itemType")
//    ItemType itemType)
}
