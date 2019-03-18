package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    String city;

    @Column(name = "post_code")
    String postCode;


    public Address(String city, String postCode) {
        this.city = city;
        this.postCode = postCode;
    }


}
