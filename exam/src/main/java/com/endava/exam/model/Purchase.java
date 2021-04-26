package com.endava.exam.model;

import com.endava.exam.model.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "purchases")
public class Purchase {


    @ManyToOne
    @JoinColumn(name = "supermarket_id")
    private Supermarket supermarket;

    @ManyToMany
    private Set<Item> items;

    @Column
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column
    @Min(value = 0)
    private Double cashAmount;

    @Column
    @Min(value = 0)
    private Double totalPrice;

    @Column
    @Min(value = 0)
    private Double change;

}
