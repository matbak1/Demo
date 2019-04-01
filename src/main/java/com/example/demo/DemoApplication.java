package com.example.demo;

import com.example.demo.repository.DeviceRepository;
import com.example.demo.repository.OfferRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("com.example.demo")
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private OfferRepository offerRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        System.out.println();

    }

}
