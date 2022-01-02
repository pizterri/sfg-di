package com.pizterri.sfgdi.controllers;

import com.pizterri.pets.PetService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created by jt on 12/28/19.
 */

@Controller
public class PetController {

    private final PetService petService;

    public PetController(@Qualifier("PetServiceImpl") PetService petService) {
        this.petService = petService;
    }



    public String whichPetIsTheBest(){
        return petService.getPetType();
    }
}
