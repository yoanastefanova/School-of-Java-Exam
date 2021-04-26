package com.endava.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "supermarket")
public class Supermarket {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid")
    private String uuid;

    @NotBlank
    @Column
    private String name;


    @NotBlank
    @Column
    private String address;


    @NotNull
    @Column(length = 10)
    @Pattern(regexp = "^0(?:9|8|7)\\d{8}$")
    private String phoneNumber;


    @NotNull
    @Column
    private String workHours;


    @OneToMany
    @JsonIgnore
    List<Item> items;
}
