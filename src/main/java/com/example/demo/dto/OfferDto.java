package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class OfferDto {

    private Long id;
    private String offerName;
    private double price;
    private int discount;

}
