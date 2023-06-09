package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;

import java.util.List;

public class ListAllEmployeesController {

    EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();

    public List getAllEmployees() {

        List<Employee> employeeList = employeeRepository.readObject();

        return employeeList;
    }

}
