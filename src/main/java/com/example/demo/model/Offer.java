package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
@Table(name = "offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "offer_name")
    private String offerName;

    @Column(name = "price")
    private double price;

    @Column(name = "discount")
    private int discount;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH},
                fetch = FetchType.EAGER)
    @JoinTable(
            name = "device_offer",
            joinColumns = @JoinColumn(name = "offer_id"),
            inverseJoinColumns = @JoinColumn(name = "device_id")
    )
    private List<Device> devices;

    public Offer(String offerName, double price, int discount) {
        this.offerName = offerName;
        this.price = price;
        this.discount = discount;
    }

    public void addDevice(Device device) {
        if (devices == null) {
            devices = new ArrayList<>();
        }
        devices.add(device);
    }

}
