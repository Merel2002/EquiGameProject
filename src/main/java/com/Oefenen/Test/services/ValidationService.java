package com.Oefenen.Test.services;

import com.Oefenen.Test.models.DTO.GameDTO;
import com.Oefenen.Test.models.DTO.RiderDTO;
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

    public boolean riderValidator(RiderDTO riderDTO){
        boolean valid1 = false;
        boolean valid2 = false;
        boolean valid3 = false;
        valid1 = this.intValidator(riderDTO.getId(), 0);
        valid2 = this.stringValidator(riderDTO.getFirstname(), 1, 30);
        valid3 = this.stringValidator(riderDTO.getLastname(), 1, 50);

        if(valid1 && valid2 && valid3){
            return true;
        }

        return false;
    }

    public boolean gameValidator(GameDTO gameDTO){
        boolean valid[] = {false, false, false, false, false};

        valid[0] = this.stringValidator(gameDTO.getName(), 0, 50);
        valid[1] = this.stringValidator(gameDTO.getDescription(), 0, 500);
        valid[2] = this.dateValidator(gameDTO.getDate());
        valid[3] = this.stringValidator(gameDTO.getLocation(), 0, 20);
        valid[4] = this.intValidator(gameDTO.getId(), 0);

        if(valid[0] && valid[1] && valid[2] && valid[3] && valid[4]){
            return true;
        }

        return false;
    }


}
