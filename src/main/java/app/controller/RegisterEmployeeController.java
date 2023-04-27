package app.controller;

import app.domain.model.Agency;
import app.domain.model.Employee;
import app.domain.model.Role;
import app.domain.repository.RegisterEmployeeRepository;

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


}
