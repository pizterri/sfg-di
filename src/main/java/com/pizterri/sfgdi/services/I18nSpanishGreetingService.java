package com.pizterri.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// Example of setting profile with Spring Annotation
// Example of setting with Java Bean impl can be found in GreetingServiceConfig

// @Profile({"ES", "default"})
// @Service("i18nService")
public class I18nSpanishGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
}
