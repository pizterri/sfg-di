package com.pizterri.sfgdi.config;

import com.pizterri.pets.CatPetService;
import com.pizterri.pets.DogPetService;
import com.pizterri.pets.PetService;
import com.pizterri.pets.PetServiceFactory;
import com.pizterri.sfgdi.datasource.FakeDataSource;
import com.pizterri.sfgdi.repositories.EnglishGreetingRepository;
import com.pizterri.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.pizterri.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

//@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${com.pizterri.username}") String username,
                                  @Value("${com.pizterri.password}") String password,
                                  @Value("${com.pizterri.jdbcurl}") String jdbcurl){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);

        return fakeDataSource;

    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    /*
    @Bean
    @Profile("cat")
    CatPetService catPetService(){
        return new CatPetService();
    }


    @Bean
    @Profile({"dog", "default"})
    DogPetService dogPetService(){
        return new DogPetService();
    }
*/

    @Bean("i18nService")
    @Profile("ES")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }
    @Bean
    @Profile("EN")
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Bean
    @Primary
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    /*
    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }
     */

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }
}
