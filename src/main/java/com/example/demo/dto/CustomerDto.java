package com.example.demo.dto;


import com.example.demo.model.Address;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CustomerDto {


    private Long id;
    private String firstName;
    private String lastName;
    private Address address;


    public CustomerDto(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
}
