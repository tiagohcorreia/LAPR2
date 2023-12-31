package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterClientController;
import pt.ipp.isep.dei.esoft.project.domain.model.Client;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class RegisterClientUI implements Runnable{
    private RegisterClientController controller = new RegisterClientController();

    @Override
    public void run() {
        //The Owner attributes are: the name, the citizen's card number, the tax number, the address, the email address and the contact telephone number. The address of the owner is not mandatory.

//        System.out.println("Name: ");
//        System.out.println("Email: ");
//        System.out.println("Password: ");
//        System.out.println("CC number: ");
//        System.out.println("Tax number: ");
//        System.out.println("Telephone number: ");
//        System.out.println("Address: ");

        List<String> input = new ArrayList<>();

        boolean userSuccessfulyCreated = false;
        Client newClient = null;
        //while (!userSuccessfulyCreated) {
            input.add(Utils.readLineFromConsole("Name: "));
            input.add(Utils.readLineFromConsole("Email: "));
            input.add(Utils.readLineFromConsole("Password: "));
            input.add(Utils.readLineFromConsole("CC Number: "));
            input.add(Utils.readLineFromConsole("Tax number: "));
            input.add(Utils.readLineFromConsole("Address: "));
            input.add(Utils.readLineFromConsole("Telephone number: "));

            newClient = controller.createClient(input);
        //}
        if (controller.saveClient(newClient))
            System.out.println("User successfully registered!");
        else
            System.out.println("User registration failed.");



    }
}
