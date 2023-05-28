package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.Employee;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Register employee repository.
 */
public class EmployeeRepository implements Serializable {

    /**
     * The constant employeeList.
     */
    public static List<Employee> employeeList = new ArrayList();

    /**
     * Create employee employee.
     *
     * @param employeeName the employee name
     * @return the employee
     */
    public Employee createEmployee (String employeeName) {

        return new Employee(employeeName);
    }

    /**
     * Save employee boolean.
     *
     * @param employee the employee
     * @return the boolean
     */
    public boolean saveEmployee(Employee employee) {

        if(validateEmployee(employee)) {

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

        if(employee != null && validateEmployee(employee)) {

            return this.employeeList.add(employee);
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

        for(Employee employee1 : employeeList) {

            if(employee.equals(employee)) {

                return false;
            }
        }
        return true;
    }

    /**
     * Gets employee list.
     *
     * @return the employee list
     */
    public List<Employee> getEmployeeList() {

        return new ArrayList<>(employeeList);
    }

    /**
     * Gets employee.
     *
     * @param employeeID the employee id
     * @return the employee
     */
    public static Employee getEmployee(String employeeID) {

        for(Employee employee : employeeList) {

            if(employee.getName().equals(employeeID)) {

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

        for(Employee employee : this.employeeList) {

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
            if (employee.getEmailAdress().equals(email)) {
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
            if (employee.getEmailAdress().equals(email)) {
                return employee;
            }
        }
        return null;
    }

    public void readObject() {

        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ser/employee.ser"));
            ois.readObject();
            System.out.println(employeeList);
            ois.close();

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();
        }
    }

    public void writeObject() {

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ser/employee.ser"));
            oos.writeObject(employeeList);
            oos.close();

        } catch (IOException ioe) {

            ioe.printStackTrace();
        }
    }
}