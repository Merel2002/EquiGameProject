package com.Oefenen.Test.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ValidationService {
    // Checks is the string is between parameters
    public boolean stringValidator(String input, int min, int max){
        boolean valid = false;
        if(input.length() < max && input.length() > min){
            valid = true;
        }
        return valid;
    }

    //Checks if an int is between parameters
    public boolean intBetweenValidator(int input, int min, int max){
        boolean valid = false;
        if(input < max && input > min){
            valid = true;
        }
        return valid;
    }

    //Checks id an int is higher than a minimum
    public boolean intValidator(int input, int min){
        boolean valid = false;
        if(input > min){
            valid = true;
        }
        return valid;
    }

    //checks if the given date is yet to come
    public boolean dateValidator(LocalDate date){
        boolean valid = false;
        LocalDate current = LocalDate.now();

        if(date.compareTo(current) > 0){
            valid = true;
        }

        return valid;
    }


}
