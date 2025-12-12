package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service          //Spring ko batata hai: “Ye Chef hai, logic handle karega”
public class GreetingService {

    public String getGreeting(String name) {                               //business logic (ye controller se call hoga)
        return "Namaste " + name + ", Service se response aa gaya!";
    }
}
