package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterBranchController;

import pt.ipp.isep.dei.esoft.project.domain.repository.BranchRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

/**
 * The type Register branch ui.
 */
public class RegisterBranchUI implements Runnable {


    private RegisterBranchController controller = new RegisterBranchController(new BranchRepository());

    /**
     * Instantiates a new Register branch ui.
     *
     * @param controller the controller
     */
    public RegisterBranchUI(RegisterBranchController controller) {
        //this.controller = controller;
    }
    @Override
    public void run() {

        //Branch ID
        Integer branchID = Utils.readIntegerFromConsole("Insert Branch ID: ");

        //Branch name
        String branchName = Utils.readLineFromConsole("Insert Branch name: ");

        //Branch location
        String branchLocation = Utils.readLineFromConsole("Insert Branch location: ");

        //Branch phoneNumber
        Integer branchPhoneNumber = Utils.readIntegerFromConsole("Insert Branch phone number: ");

        //Branch email
        String branchEmail = Utils.readLineFromConsole("Insert Branch email: ");



        int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

        if (optValidation == 1) {

            controller.createBranch(branchID, branchName, branchLocation, branchPhoneNumber, branchEmail);

            System.out.println("Branch created!");

        } else {

            System.err.println("Operation Canceled!");

        }

    }


}
