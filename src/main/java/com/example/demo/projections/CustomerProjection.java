package com.example.demo.projections;

public interface CustomerProjection {

    String getFirstName();
    Address getAddress();

    interface Address {
        String getCity();
    }

}
