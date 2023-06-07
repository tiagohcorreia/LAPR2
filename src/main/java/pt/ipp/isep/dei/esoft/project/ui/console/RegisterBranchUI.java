package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterBranchController;

import pt.ipp.isep.dei.esoft.project.domain.model.Branch;
import pt.ipp.isep.dei.esoft.project.domain.model.Location;
import pt.ipp.isep.dei.esoft.project.domain.repository.BranchRepository;
import pt.ipp.isep.dei.esoft.project.exceptions.DuplicateDataException;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

/**
 * The type Register branch ui.
 */
public class RegisterBranchUI implements Runnable {
    private RegisterBranchController controller = new RegisterBranchController();

    @Override
    public void run() {

        //Branch ID
        Integer branchID = Utils.readIntegerFromConsole("Insert Branch ID: ");

        //Branch name
        String branchName = Utils.readLineFromConsole("Insert Branch name: ");

        //Branch location
        System.out.println("Branch location");
        String branchDoorNumber = String.valueOf(Utils.readIntegerFromConsole("Branch door number: "));
        //int branchDoorNumber = Utils.readIntegerFromConsole("Branch door number: ");
        String branchStreet = Utils.readLineFromConsole("Branch street: ");
        String branchState =  Utils.readLineFromConsole("Branch state: ");
        String branchDistrict = Utils.readLineFromConsole("Branch district: ");
        String branchCity = Utils.readLineFromConsole("Branch city: ");
        String branchZipCode = String.valueOf(Utils.readIntegerFromConsole("Branch zip code: "));
        //int branchZipCode = Utils.readIntegerFromConsole("Branch zip code: ");

        Location branchLocation = controller.createLocation(branchDoorNumber, branchStreet, branchCity, branchDistrict, branchState, branchZipCode);

        //Branch phoneNumber
        String branchPhoneNumber = Utils.readLineFromConsole("Insert Branch phone number: ");

        //Branch email
        String branchEmail = Utils.readLineFromConsole("Insert Branch email: ");


        try {

            Branch branch = controller.createBranch(branchID, branchName, branchLocation, branchPhoneNumber, branchEmail);
            System.out.println(branch);

            int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

            if (optValidation == 1) {

                if (controller.saveBranch(branch))

                    System.out.println("Branch created!");

                else

                    System.err.println("Failed to create branch!");

            } else {

                System.err.println("Operation Canceled!");
            }


        } catch (DuplicateDataException e) {

            System.err.println(e.getMessage());

        } catch (NullPointerException e) {

            System.err.println(e.getMessage());

        } catch (IllegalArgumentException e) {

            System.err.println(e.getMessage());

        } catch (IllegalStateException e) {


        }

    }


}
