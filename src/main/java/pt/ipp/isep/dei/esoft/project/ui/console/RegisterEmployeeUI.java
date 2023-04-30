package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterEmployeeController;
import pt.ipp.isep.dei.esoft.project.domain.model.Agency;
import pt.ipp.isep.dei.esoft.project.domain.model.Role;
import pt.ipp.isep.dei.esoft.project.domain.repository.RegisterEmployeeRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class RegisterEmployeeUI implements Runnable {

    private RegisterEmployeeController controller = new RegisterEmployeeController(new RegisterEmployeeRepository());

    public RegisterEmployeeUI(RegisterEmployeeController controller) {
        //this.controller = controller;
    }

    @Override
    public void run() {

        boolean success = true;

        while (success) {


            //Employee name
            String emplyeeName = Utils.readLineFromConsole("Insert Employee name: ");

            //Passport Number
            Integer employeePassportNumber = Utils.readIntegerFromConsole("Insert Passport Number: ");

            //TaxNumber
            Integer taxNumber = Utils.readIntegerFromConsole("Insert Tax Number: ");

            //Address
            String address = Utils.readLineFromConsole("Insert Address: ");

            //E-mail
            String eMail = Utils.readLineFromConsole("Insert E-mail: ");

            //Telephone Number
            Integer telephoneNumber = Utils.readIntegerFromConsole("Insert Telephone Number: ");

            //Role
            List<Role> x = this.controller.getRolesAsList();
            Utils.showList(x, "Roles");
            Integer posRole = Utils.readIntegerFromConsole("Choose a Role for the Employee: ");

            //Agency
            List<Agency> y = this.controller.getAgency();
            Utils.showList(y, "Agency");
            Integer posAgency = Utils.readIntegerFromConsole("Choose a Agency for the Employee: ");


            int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

            if (optValidation == 1) {

                try {

                    this.controller.createEmployee(emplyeeName, employeePassportNumber, taxNumber, address, eMail, telephoneNumber, posRole, posAgency);
                    this.controller.sendEmail(emplyeeName, eMail);
                    success = false;

                    if (success) {

                        System.out.println("Please insert Employee data again");
                    }

                } catch (IllegalArgumentException e) {

                    System.err.println(e.getMessage());

                } catch (NullPointerException e) {

                    System.err.println(e.getMessage());

                } catch (Exception e) {

                    System.out.println(e.getMessage());

                }

                System.out.println("Employee name: " + emplyeeName);
                System.out.println("Employee Passport Number: " + employeePassportNumber);
                System.out.println("Employee Address: " + address);
                System.out.println("Employee E-mail: " + eMail);
                System.out.println("Employee Telephone Number: " + telephoneNumber);
                System.out.println("Employee Role: " + Role.getRoleById(posRole));
                System.out.println("Employee Agency: " + Agency.getAgencyById(posAgency));

            } else {

                System.err.println("Operation Canceled!");
            }


        }

    }
}
