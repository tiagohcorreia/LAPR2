package app.domain.repository;

import app.domain.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class RegisterEmployeeRepository {

    public static List<Employee> employeeList = new ArrayList();

    public Employee createEmployee (String employeeName) {

        return new Employee(employeeName);
    }

    public boolean saveEmployee(Employee employee) {

        if(validateEmployee(employee)) {

            return addEmployee(employee);
        }
        return false;
    }

    public boolean addEmployee(Employee employee) {

        if(employee != null && validateEmployee(employee)) {

            return this.employeeList.add(employee);
        }
        return false;
    }

    public boolean validateEmployee(Employee employee) {

        for(Employee employee1 : employeeList) {

            if(employee.equals(employee)) {

                return false;
            }
        }
        return true;
    }

    public List<Employee> getEmployeeList() {

        return new ArrayList<>(employeeList);
    }

    public static Employee getEmployee(String employeeID) {

        for(Employee employee : employeeList) {

            if(employee.getName().equals(employeeID)) {

                return employee;
            }
        }
        return null;
    }

    public String getEmployeeListAsString() {

        StringBuilder stringBuilder = new StringBuilder();

        for(Employee employee : this.employeeList) {

            stringBuilder.append("-").append(employee.toString()).append("\n");

        }
        return stringBuilder.toString();
    }
}
