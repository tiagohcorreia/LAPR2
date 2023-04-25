package app.controller;

import app.domain.model.Agency;
import app.domain.model.Employee;
import app.domain.model.Role;
import app.domain.repository.RegisterEmployeeRepository;

public class RegisterEmployeeController {

    private RegisterEmployeeRepository employeeRepository;

    public RegisterEmployeeController(RegisterEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String getRole() {
        return Role.asString();
    }

    public String getAgency() {
        return Agency.asString();
    }

    public void createEmployee(String employeeName, int passportNumber, int taxNumber, String address, String eMail,
                               int telephoneNumber, Role role, Agency agency) {

    }




}
