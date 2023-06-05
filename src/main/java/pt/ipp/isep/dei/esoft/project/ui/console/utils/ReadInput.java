package pt.ipp.isep.dei.esoft.project.ui.console.utils;

public class ReadInput {
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

    public boolean validateEmail(String email){
        return email.contains("@") ? true : false;
    }


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

    public boolean validateInteger(int number, int min, int max) {
        if (number < min || number > max)
            return false;
        return true;
    }
}
