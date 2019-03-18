package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class DeviceDto {

    private Long id;
    private String name;
    private String description;
    private double price;
}
