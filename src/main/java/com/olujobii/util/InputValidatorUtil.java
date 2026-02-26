package com.olujobii.util;

public class InputValidatorUtil {

    public static boolean isAValidInteger(String userInput){
        try{
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validateUserAge(int userAge){
        return userAge < 16 || userAge > 20;
    }
}
