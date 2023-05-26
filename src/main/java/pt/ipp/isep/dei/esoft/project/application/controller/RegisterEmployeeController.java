package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.Agency;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.model.Role;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;

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

    private EmployeeRepository employeeRepository;

    /**
     * Instantiates a new Register employee controller.
     *
     * @param employeeRepository the employee repository
     */
    public RegisterEmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Gets roles as list.
     *
     * @return the roles as list
     */
    public List<Role> getRolesAsList() {
        return Arrays.stream(Role.values()).toList();
    }

    /**
     * Gets agency.
     *
     * @return the agency
     */
    public List<Agency> getAgency() {
        return Arrays.stream(Agency.values()).toList();
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
     * @param posAgency       the pos agency
     * @return the string
     */
    public String createEmployee(String employeeName, int passportNumber, int taxNumber, String address, String eMail,
                                 int telephoneNumber, Integer posRole, Integer posAgency) {

        Employee newEmployee = new Employee(employeeName, passportNumber, taxNumber, address, eMail, telephoneNumber,
                Role.getRoleById(posRole), Agency.getAgencyById(posAgency));

        try {

            this.employeeRepository.saveEmployee(newEmployee);
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
