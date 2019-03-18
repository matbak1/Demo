package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH},
                fetch = FetchType.EAGER)
    @JoinTable(
            name = "device_offer",
            joinColumns = @JoinColumn(name = "device_id"),
            inverseJoinColumns = @JoinColumn(name = "offer_id")
    )
    private List<Offer> offers;

    public Device(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void addOffer(Offer offer) {
        if (offers == null) {
            offers = new ArrayList<>();
        }
        offers.add(offer);
    }

}

