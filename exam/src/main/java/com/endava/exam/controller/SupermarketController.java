package com.endava.exam.controller;


import com.endava.exam.dto.*;
import com.endava.exam.model.Item;
import com.endava.exam.model.Supermarket;
import com.endava.exam.service.SupermarketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.xml.ws.Response;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/a1/supermarket")
@RequiredArgsConstructor
public class SupermarketController {

    private final SupermarketService supermarketService;
    private final ModelMapper modelMapper;


    @PostMapping(value = "/create-supermarket", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SupermarketResponseDto> createSupermarket(@Valid @RequestBody CreateSupermarketRequestDto dto, HttpServletResponse response) {
        return new ResponseEntity((modelMapper.map(supermarketService.createSupermarket(dto), SupermarketResponseDto.class)), HttpStatus.CREATED);
    }



    @PostMapping(value = "/add-items-to-supermarket", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdditionResponseDto> addItemsToSupermarket(@Valid @RequestBody AdditionRequestDto addItemToSupermarketRequestDto) {
        Supermarket supermarket = supermarketService.addItemsToSupermarket(addItemToSupermarketRequestDto);
        AdditionResponseDto responseDto = new AdditionResponseDto();
        responseDto.setSupermarketId(supermarket.getUuid());
        responseDto.setItemName(supermarket.getItems().stream().map(Item::getName).collect(Collectors.toList()));
        return ResponseEntity.ok(responseDto);
    }


    @GetMapping(value = "/get-supermarket-by-id")
    public ResponseEntity<SupermarketResponseIdDto> getSupermarketById(@Valid @NotBlank(message = "Invalid ID!") @RequestParam("id") String id) {
        return ResponseEntity.ok(modelMapper.map(supermarketService.getSupermarketById(id), SupermarketResponseIdDto.class));
    }

}
