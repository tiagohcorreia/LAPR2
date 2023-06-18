package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.model.Branch;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.model.Role;
import pt.ipp.isep.dei.esoft.project.exceptions.DuplicateDataException;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Employee repository.
 */
public class EmployeeRepository implements Serializable {

    /**
     * The constant employeeList.
     */
    public static List<Employee> employeeList = new ArrayList<>();

    /**
     * The Authentication repository.
     */
    AuthenticationRepository authenticationRepository = pt.ipp.isep.dei.esoft.project.repository.Repositories.getInstance().getAuthenticationRepository();

    /**
     * Create employee employee.
     *
     * @param employeeName the employee name
     * @return the employee
     */
    public Employee createEmployee(String employeeName) {

        return new Employee(employeeName);
    }

    /**
     * Create employee employee.
     *
     * @param name            the name
     * @param passportNumber  the passport number
     * @param taxNumber       the tax number
     * @param address         the address
     * @param emailAdress     the email adress
     * @param telephoneNumber the telephone number
     * @param role            the role
     * @param branch          the branch
     * @return the employee
     */
    public Employee createEmployee(String name, int passportNumber, int taxNumber, String address, String emailAdress, String telephoneNumber, Role role, Branch branch) {
        return new Employee(name, passportNumber, taxNumber, address, emailAdress, telephoneNumber, role, branch);
    }


    /**
     * Save employee boolean.
     *
     * @param employee the employee
     * @return the boolean
     */
    public boolean saveEmployee(Employee employee) {

        if (validateEmployee(employee)) {

            return addEmployee(employee);
        }
        return false;
    }

    /**
     * Add employee boolean.
     *
     * @param employee the employee
     * @return the boolean
     */
    public boolean addEmployee(Employee employee) {

        if (employee != null && validateEmployee(employee)) {

            return employeeList.add(employee);
        }
        return false;
    }

    /**
     * Validate employee boolean.
     *
     * @param employee the employee
     * @return the boolean
     */
    public boolean validateEmployee(Employee employee) {

        for (Employee emp : employeeList) {

            if (emp.equals(employee)) {

                throw new DuplicateDataException("Employee is already registered");
            }
        }
        return true;
    }

    /**
     * Gets employee list.
     *
     * @return the employee list
     */
    public static List<Employee> getEmployeeList() {

        return new ArrayList<>(employeeList);
    }

    /**
     * Gets employee.
     *
     * @param employeeID the employee id
     * @return the employee
     */
    public static Employee getEmployee(String employeeID) {

        for (Employee employee : employeeList) {

            if (employee.getName().equals(employeeID)) {

                return employee;
            }
        }
        return null;
    }


    /**
     * Gets employee list as string.
     *
     * @return the employee list as string
     */
    public String getEmployeeListAsString() {

        StringBuilder stringBuilder = new StringBuilder();

        for (Employee employee : this.employeeList) {

            stringBuilder.append("-").append(employee.toString()).append("\n");

        }
        return stringBuilder.toString();
    }

    /**
     * Gets user by email.
     *
     * @param email the email
     * @return the user by email
     */
    public Employee getUserByEmail(String email) {
        for (Employee employee : employeeList) {
            if (employee.getEmailAddress().equals(email)) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Find by email employee.
     *
     * @param email the email
     * @return the employee
     */
    public Employee findByEmail(String email) {
        for (Employee employee : employeeList) {
            if (employee.getEmailAddress().equals(email)) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Find by name employee.
     *
     * @param name the name
     * @return the employee
     */
    public Employee findByName(String name) {
        for (Employee employee : employeeList) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Read object.
     *
     * @return the list
     */
    public List<Employee> readObject() {

        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ser/employee.ser"));
            employeeList = (List<Employee>) ois.readObject();
            ois.close();

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();
        }
        return employeeList;
    }

    /**
     * Write object.
     */
    public void writeObject() {

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ser/employee.ser"));
            oos.writeObject(employeeList);
            oos.close();

        } catch (IOException ioe) {

            ioe.printStackTrace();
        }
    }

    /**
     * Save employee in the system.
     *
     * @param newEmployee the new employee
     * @param password    the password
     */
    public void saveEmployeeInTheSystem(Employee newEmployee, String password) {

        if (newEmployee.getRole().equals(Role.ADMNISTRATOR)) {

            authenticationRepository.addUserWithRole(newEmployee.getName(), newEmployee.getEmailAddress(), password, AuthenticationController.ROLE_ADMIN);

        } else if (newEmployee.getRole().equals(Role.NETWORK_MANAGER)) {

            authenticationRepository.addUserWithRole(newEmployee.getName(), newEmployee.getEmailAddress(), password, AuthenticationController.ROLE_NETWORK_MANAGER);

        } else if (newEmployee.getRole().equals(Role.AGENT)) {

            authenticationRepository.addUserWithRole(newEmployee.getName(), newEmployee.getEmailAddress(), password, AuthenticationController.ROLE_AGENT);
        }
    }
}
