package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Validator {
    default boolean validatePhoneNumber(int number){
        return  (number >= 100000000 && number <= Integer.MAX_VALUE);
    }

    default boolean validatePhoneNumber(String number){
        Pattern pattern = Pattern.compile("^[0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);
        int a = number.length();
        if(!(number.length() >= 9 && number.length() <= 10 && matcher.find()))
            throw new IllegalArgumentException("The phone number " + number + " is invalid, it must contain 10 digits.");
        return true;
    }


    default boolean validateTaxNumber(int number){
        if (!(number >= 100000000 && number <= 999999999))
            throw new IllegalArgumentException("The tax number " + number + " is invalid. It must contain 9 digits.");
        return true;
    }

    default boolean validateTaxNumber(String number){
        Pattern pattern = Pattern.compile("^[0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);

        return  (number.length() >= 9 && number.length() <= 10 && !matcher.find());
    }


    default boolean validatePassportNumber(int number){
        return  (number >= 100000000 && number <= 999999999);
    }

    default boolean validatePassportNumber(String number){
        Pattern pattern = Pattern.compile("^[0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);

        return  (number.length() >= 9 && number.length() <= 10 && !matcher.find());
    }


    default boolean validateZipCode(int number){
        return  (number >= 10000 && number <= 999999);
    }

    default boolean validateZipCode(String number){
        Pattern pattern = Pattern.compile("^[0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);

        return  (number.length() >= 5 && number.length() <= 6 && !matcher.find());
    }


    default boolean validateInteger(int number){
        return  (number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE);
    }

    default boolean validateInteger(String number){
        Pattern pattern = Pattern.compile("^[0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);

        return  (number.length() >= 1 && !matcher.find());
    }

    default boolean validateString(String str){
        return (!str.isEmpty() && !str.isBlank() && str != null);
    }

    default boolean validateEmail(String email){
        return (email.contains("@") && email.contains("."));
    }

    default boolean validateObject(Object obj){
        return (obj != null);
    }

}
