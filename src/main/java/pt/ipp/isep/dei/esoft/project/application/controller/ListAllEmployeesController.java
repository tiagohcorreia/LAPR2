package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;

import java.util.List;

/**
 * The type List all employees controller.
 */
public class ListAllEmployeesController {

    /**
     * The Employee repository.
     */
    EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();

    /**
     * Gets all employees.
     *
     * @return the all employees
     */
    public List getAllEmployees() {

        List<Employee> employeeList = employeeRepository.readObject();

        return employeeList;
    }

}
