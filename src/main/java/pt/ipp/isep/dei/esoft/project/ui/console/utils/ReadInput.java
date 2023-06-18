package pt.ipp.isep.dei.esoft.project.ui.console.utils;

/**
 * The type Read input.
 */
public class ReadInput {
    /**
     * Email string.
     *
     * @param prompt the prompt
     * @return the string
     */
    public String email(String prompt) {
        boolean valid = false;
        String input = "";
        while (!valid) {
            input = Utils.readLineFromConsole(prompt).trim();
            valid = validateEmail(input);
            if (!valid){
                System.out.println("Email must contain \"@\"!");
            }
        }
        return input;
    }

    /**
     * Validate email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public boolean validateEmail(String email){
        return email.contains("@") ? true : false;
    }


    /**
     * Integer int.
     *
     * @param prompt the prompt
     * @param min    the min
     * @param max    the max
     * @return the int
     */
    public int integer(String prompt, int min, int max){
        boolean valid = false;
        int input = 0;
        while (!valid) {
            input = Utils.readIntegerFromConsole(prompt);
            valid = validateInteger(input, min, max);
            if (!valid){
                System.out.println("Email must contain \"@\"!");
            }
        }
        return input;
    }

    /**
     * Validate integer boolean.
     *
     * @param number the number
     * @param min    the min
     * @param max    the max
     * @return the boolean
     */
    public boolean validateInteger(int number, int min, int max) {
        if (number < min || number > max)
            return false;
        return true;
    }
}
