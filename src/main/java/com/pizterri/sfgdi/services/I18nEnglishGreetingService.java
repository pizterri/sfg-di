package com.pizterri.sfgdi.services;

import com.pizterri.sfgdi.repositories.EnglishGreetingRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
// Example of setting profile with Spring Annotation
// Example of setting with Java Bean impl can be found in GreetingServiceConfig
//@Profile("EN")
//@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService{
    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        //return "Hello World - EN";
        return englishGreetingRepository.getGreeting();
    }
}
