package pt.ipp.isep.dei.esoft.project.domain.shared;

import java.util.Random;

/**
 * The type Password generator.
 */
public class PasswordGenerator {

    /**
     * Instantiates a new Password generator.
     */
    public PasswordGenerator() {
    }

    private static final int PASSWORD_SIZE = 7;

    /**
     * Generate password string.
     *
     * @return the string
     */
    public static String generatePassword() {

        String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < PASSWORD_SIZE; i++) {

            password.append(allowedCharacters.charAt(random.nextInt(allowedCharacters.length())));
        }

        return password.toString();
    }
}



