package com.example.demo.aop;

import com.example.demo.dto.CustomerDto;
import com.example.demo.service.CustomerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CustomerAspect {

    @Autowired
    CustomerService customerService;

    @Pointcut("execution(void create*(*))")
    public void customerCreate() {
    }

    @Pointcut("execution(void createOffer(*))")
    public void offerAdd(){

    }

    @Before("customerCreate()")
    public void beforeCustomerCreate(JoinPoint joinPoint) {
        int numberOfCustomers = customerService.getCustomerCount().intValue();
        Object[] objects = joinPoint.getArgs();

        System.out.println("Number of customers before add: "+numberOfCustomers);

        for (Object object : objects) {
            System.out.println(object.toString());

            if (object instanceof CustomerDto){
                CustomerDto customer = (CustomerDto) object;

                System.out.println("Customer " + customer.getFirstName() + " " + customer.getLastName() + " saved successful");
            }
        }


    }

    @After("customerCreate()")
    public void afterCustomerCreate() {
        int numberOfCustomers = (int) customerService.getCustomerCount().intValue();

        System.out.println("Number of customers after add: " + numberOfCustomers);
    }
}
