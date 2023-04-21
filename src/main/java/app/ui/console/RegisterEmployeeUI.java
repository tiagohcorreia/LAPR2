package app.ui.console;

import app.controller.RegisterEmployeeController;
import app.ui.console.utils.Utils;

import javax.management.relation.Role;

public class RegisterEmployeeUI implements Runnable {

    private RegisterEmployeeController controller;

    public RegisterEmployeeUI(RegisterEmployeeController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {

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

        //Agency


        int optValidation = Utils.readIntegerFromConsole("1-CONFIRM\n0-CANCEL");

        if(optValidation == 1) {
            /*this.controller.createEmployee(emplyeeName, employeePassportNumber,
                    address, address, eMail, telephoneNumber,role,agency);*/

            System.out.println("Employee name: " + emplyeeName);
            System.out.println("Employee Passport Number: " + employeePassportNumber);
            System.out.println("Employee Address: " + address);
            System.out.println("Employee E-mail: " + eMail);
            System.out.println("Employee Telephone Number: " + telephoneNumber);
            //System.out.println("Employee Role: " + );
            //System.out.println("Employee Agency: " + );

        } else {
            System.err.println("Operation Canceled!");
        }

    }
}
