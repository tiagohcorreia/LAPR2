package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.*;
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

    private EmployeeRepository employeeRepository = new EmployeeRepository();

    private BranchRepository branchRepository = new BranchRepository();

    /**
     * Instantiates a new Register employee controller.
     *
     * @param employeeRepository the employee repository
     */
    public RegisterEmployeeController(EmployeeRepository employeeRepository) {

        this.branchRepository.readObject();
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
            System.out.println();
            return newEmployee.toString();

        } catch (Exception e) {

            throw new IllegalStateException(e.getMessage().toString());
        }

    }

    /**
     * Send email.
     *
     * @param emplyeeName the emplyee name
     * @param eMail       the e mail
     */
    public void sendEmail(String emplyeeName, String eMail) {

        String password = generatePassword();
        String conteudo = "Email: " + eMail + " | Senha: " + password;

        try {

            FileWriter file = new FileWriter(new File("APP_FILES/email.txt"));
            file.write(conteudo + "\n");
            file.close();
            System.out.println("File with employee credentials generated with success");

        } catch (IOException e) {

            System.out.println("Error creating file");
            e.printStackTrace();
        }
    }


}
