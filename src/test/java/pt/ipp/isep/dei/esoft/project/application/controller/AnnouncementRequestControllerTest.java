package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementRequestDTO;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;

 import java.util.List;

public class AnnouncementRequestControllerTest {
    @Test
    public void ensureGetEmployeeReturnsCorrectEmployee() {
        AnnouncementRequestsController controller = new AnnouncementRequestsController();
        String name = "John Doe";
        Employee expectedEmployee = new Employee(name);

        controller.employeeRepository.addEmployee(expectedEmployee);
        Employee actualEmployee = controller.getEmployee(name);

        Assert.assertEquals(expectedEmployee, actualEmployee);
    }

    /*@Test
    public void ensureIsEmployeeReturnsTrueForExistingEmployee() {
        AnnouncementRequestsController controller = new AnnouncementRequestsController();
        String agentName = "John Doe";
        Employee existingEmployee = new Employee(agentName);
        controller.employeeRepository.addEmployee(existingEmployee);

        boolean result = controller.isEmployee(agentName);

        Assert.assertTrue(result);
    }*/


}

