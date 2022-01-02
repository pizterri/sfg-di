package com.pizterri.sfgdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
// Implementation of primary bean with Spring annotation
//@Primary
//@Service
public class PrimaryGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello World - Primary";
    }
}
