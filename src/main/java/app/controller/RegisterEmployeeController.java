package app.controller;

import app.domain.model.Agency;
import app.domain.repository.RegisterEmployeeRepository;


import javax.management.relation.Role;

public class RegisterEmployeeController {

    private RegisterEmployeeRepository employeeRepository;

    public void createEmployee(String employeeName, int passportNumber, int taxNumber, String address, String eMail,
                               int telephoneNumber, Role role, Agency agency) {


    }

}
