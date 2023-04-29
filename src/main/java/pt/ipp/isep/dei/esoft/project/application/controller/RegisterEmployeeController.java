package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.Agency;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.model.Role;
import pt.ipp.isep.dei.esoft.project.domain.repository.RegisterEmployeeRepository;

import java.util.Arrays;
import java.util.List;

public class RegisterEmployeeController {

    private RegisterEmployeeRepository employeeRepository;

    public RegisterEmployeeController(RegisterEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Role> getRolesAsList() {
        return Arrays.stream(Role.values()).toList();
    }

    public List<Agency> getAgency() {
        return Arrays.stream(Agency.values()).toList();
    }


    public String createEmployee(String employeeName, int passportNumber, int taxNumber, String address, String eMail,
                                 long telephoneNumber, Integer posRole, Integer posAgency)  {

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


}
