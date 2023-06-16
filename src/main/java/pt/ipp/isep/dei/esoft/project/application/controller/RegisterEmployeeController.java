package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.BranchRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static pt.ipp.isep.dei.esoft.project.domain.shared.PasswordGenerator.generatePassword;

/**
 * The type Register employee controller.
 */
public class RegisterEmployeeController {

    private EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();

    private BranchRepository branchRepository = Repositories.getInstance().getBranchRepository();

    AuthenticationRepository authenticationRepository;


    public RegisterEmployeeController() {

        //this.branchRepository.readObject();
    }

    /**
     * Gets roles as list.
     *
     * @return the roles as list
     */
    public List<Role> getRolesAsList() {
        return Arrays.stream(Role.values()).toList();
    }


    public List<Branch> getBranchList() {

        return branchRepository.readObject();
    }


    /**
     * Create employee string.
     *
     * @param employeeName    the employee name
     * @param passportNumber  the passport number
     * @param taxNumber       the tax number
     * @param address         the address
     * @param eMail           the e mail
     * @param telephoneNumber the telephone number
     * @param posRole         the pos role
     * @param posBranch       the pos agency
     * @return the string
     */
    public String createEmployee(String employeeName, int passportNumber, int taxNumber, String address, String eMail,
                                 String telephoneNumber, Integer posRole, Integer posBranch) {

        Employee newEmployee = new Employee(employeeName, passportNumber, taxNumber, address, eMail, telephoneNumber,
                Role.getRoleById(posRole), BranchRepository.getBranchByID(posBranch));

        try {

            this.employeeRepository.saveEmployee(newEmployee);
            this.employeeRepository.writeObject();
            this.employeeRepository.saveEmployeeInTheSystem(newEmployee, sendEmail(newEmployee.getEmailAddress()));
            System.out.println();
            System.out.println(newEmployee);
            return newEmployee.toString();

        } catch (Exception e) {

            throw new IllegalStateException(e.getMessage().toString());
        }

    }

    /**
     * Send email.
     *
     * @param eMail       the e mail
     */
    public String sendEmail(String eMail) {

        String password = generatePassword();
        String conteudo = "Email: " + eMail + " | Password: " + password;

        try {

            FileWriter file = new FileWriter(new File("APP_FILES/email.txt"), true);
            file.write(conteudo + "\n");
            file.close();
            System.out.println("File with employee credentials generated with success");

        } catch (IOException e) {

            System.out.println("Error creating file");
            e.printStackTrace();
        }
        return password;
    }

    public Branch showSelectedBranch(int posBranch) {

        for (int i = 0; i < branchRepository.getBranchList().size(); i++) {

            if(posBranch >= branchRepository.getBranchList().size() && posBranch < branchRepository.getBranchList().size() && posBranch == i) {

                return branchRepository.getBranchList().get(posBranch);
            }
        }
        return null;
    }


}
