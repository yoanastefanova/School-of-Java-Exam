package com.endava.exam.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateSupermarketRequestDto {

    @NotBlank(message = "Please enter a name for the supermarket!")
    @Size(max = 64, message = "The name you entered is too long!")
    private String name;


    @Size(max = 128, message = "The address you entered is too long!")
    //TODO validator//{city}, {street} {street number} TODO
    private String address;


    @NotNull(message = "Please provide a phone number.")
    @Pattern(regexp = "^0(?:9|8|7)\\d{8}$")
    private String phoneNumber;


    @NotNull(message = "Please provide the working hours.")
    //TODO {HH:mm}-{HH:mm}
    private String workHours;
}



