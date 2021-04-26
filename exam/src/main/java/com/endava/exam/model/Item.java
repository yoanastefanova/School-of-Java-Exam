package com.endava.exam.model;

import com.endava.exam.model.enums.ItemType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Item {


    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid")
    private String uuid;


    @NotBlank
    @Column
    private String name;


    @NotNull
    @Column
    private Double price;


    @NotNull
    @Enumerated(EnumType.STRING)
    private ItemType itemType;


    @ManyToOne
    @JsonIgnore
    private Supermarket supermarket;

}
