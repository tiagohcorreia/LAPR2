package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The interface Validator.
 */
public interface Validator {
    /**
     * Validate phone number boolean.
     *
     * @param number the number
     * @return the boolean
     */
    default boolean validatePhoneNumber(int number){
        return  (number >= 100000000 && number <= Integer.MAX_VALUE);
    }

    /**
     * Validate phone number boolean.
     *
     * @param number the number
     * @return the boolean
     */
    default boolean validatePhoneNumber(String number){
        Pattern pattern = Pattern.compile("^[0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);
        int a = number.length();
        if(!(number.length() >= 9 && number.length() <= 10 && matcher.find()))
            throw new IllegalArgumentException("The phone number " + number + " is invalid, it must contain 10 digits.");
        return true;
    }


    /**
     * Validate tax number boolean.
     *
     * @param number the number
     * @return the boolean
     */
    default boolean validateTaxNumber(int number){
        if (!(number >= 100000000 && number <= 999999999))
            throw new IllegalArgumentException("The tax number " + number + " is invalid. It must contain 9 digits.");
        return true;
    }

    /**
     * Validate tax number boolean.
     *
     * @param number the number
     * @return the boolean
     */
    default boolean validateTaxNumber(String number){
        Pattern pattern = Pattern.compile("^[0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);

        return  (number.length() >= 9 && number.length() <= 10 && !matcher.find());
    }


    /**
     * Validate passport number boolean.
     *
     * @param number the number
     * @return the boolean
     */
    default boolean validatePassportNumber(int number){
        return  (number >= 100000000 && number <= 999999999);
    }

    /**
     * Validate passport number boolean.
     *
     * @param number the number
     * @return the boolean
     */
    default boolean validatePassportNumber(String number){
        Pattern pattern = Pattern.compile("^[0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);

        return  (number.length() >= 9 && number.length() <= 10 && !matcher.find());
    }


    /**
     * Validate zip code boolean.
     *
     * @param number the number
     * @return the boolean
     */
    default boolean validateZipCode(int number){
        return  (number >= 10000 && number <= 999999);
    }

    /**
     * Validate zip code boolean.
     *
     * @param number the number
     * @return the boolean
     */
    default boolean validateZipCode(String number){
        Pattern pattern = Pattern.compile("^[0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);

        return  (number.length() >= 5 && number.length() <= 6 && !matcher.find());
    }


    /**
     * Validate integer boolean.
     *
     * @param number the number
     * @return the boolean
     */
    default boolean validateInteger(int number){
        return  (number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE);
    }

    /**
     * Validate integer boolean.
     *
     * @param number the number
     * @return the boolean
     */
    default boolean validateInteger(String number){
        Pattern pattern = Pattern.compile("^[0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);

        return  (number.length() >= 1 && !matcher.find());
    }

    /**
     * Validate string boolean.
     *
     * @param str the str
     * @return the boolean
     */
    default boolean validateString(String str){
        return (!str.isEmpty() && !str.isBlank() && str != null);
    }

    /**
     * Validate email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    default boolean validateEmail(String email){
        return (email.contains("@") && email.contains("."));
    }

    /**
     * Validate object boolean.
     *
     * @param obj the obj
     * @return the boolean
     */
    default boolean validateObject(Object obj){
        return (obj != null);
    }

}
