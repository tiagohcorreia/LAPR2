package pt.ipp.isep.dei.esoft.project.domain.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.model.Branch;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.model.Role;
import pt.ipp.isep.dei.esoft.project.exceptions.DuplicateDataException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {

    public static final Branch branch = new Branch();
    EmployeeRepository employeeRepository1 = new EmployeeRepository();

    @DisplayName("Ensure Duplicate Employee Fails")
    @Test
    void EnsureDuplicateEmployeeNameFails() {

        assertThrows(DuplicateDataException.class, () -> {

            Employee e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", "9876543210" , Role.AGENT, branch);
            employeeRepository1.saveEmployee(e1);
            Employee e2 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", "9876543210", Role.AGENT, branch);
            employeeRepository1.saveEmployee(e2);
        });
    }

    @DisplayName("Ensure Validate Works")
    @Test
    void EnsureValidateWorks() {

        Employee e3 = new Employee("Employee", 987654321, 123456789, "Rua 1", "e1@gmail.com", "9876543210" , Role.AGENT, branch);
        assertTrue(employeeRepository1.validateEmployee(e3));

    }

}