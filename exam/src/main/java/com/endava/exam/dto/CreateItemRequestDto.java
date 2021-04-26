package com.endava.exam.dto;


import com.endava.exam.exceptions.validations.ValidItemType;
import com.endava.exam.model.enums.ItemType;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.*;

@Getter
@Setter
public class CreateItemRequestDto {

    @NotBlank(message="Please enter a name for the item!")
    @Size(max=64, message="The name you entered is too long!")
    private String name;


    @DecimalMin(value="0.01", message="The price should be between 0,01 and 9999,99.")
    @DecimalMax(value="9999.99", message="The price should be between 0,01 and 9999,99.")
    private Double price;


    @NotNull
    @ValidItemType
    private ItemType itemType;

}
