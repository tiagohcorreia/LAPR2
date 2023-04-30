package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.domain.TaskCategory;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrganizationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TaskCategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


/**
 * The type Create task controller it.
 */
class CreateTaskControllerIT {

    /**
     * Ensure create task works.
     */
    @Test
    void ensureCreateTaskWorks() {

        //Arrange
        //Get Repositories
        Repositories repositories = Repositories.getInstance();
        TaskCategoryRepository taskCategoryRepository = new TaskCategoryRepository();
        OrganizationRepository organizationRepository = new OrganizationRepository();
        AuthenticationRepository authenticationRepository = new AuthenticationRepository();

        //Fill Task Category Repository
        taskCategoryRepository.add(new TaskCategory("Task Category Description"));

        //Fill Organization Repository
        Organization organization = new Organization("123456789");
        Employee employee = new Employee("john.doe@this.company.com");
        organization.addEmployee(employee);
        organizationRepository.add(organization);

        //Add authentication for user john.doe@this.company.com
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserWithRole("Main Administrator", "john.doe@this.company.com", "admin",
                AuthenticationController.ROLE_ADMIN);


        CreateTaskController controller =
                new CreateTaskController(organizationRepository, taskCategoryRepository, authenticationRepository);

        //Act
        Optional<Task> newTask =
                controller.createTask("reference", "description", "informal description", "tecnical " + "description",
                        1, 1d, "Task" + " Category Description");
    }

    /**
     * Ensure get categories work.
     */
    @Test
    void ensureGetCategoriesWork() {
        //Arrange
        //Get Repositories
        Repositories repositories = Repositories.getInstance();
        TaskCategoryRepository taskCategoryRepository = new TaskCategoryRepository();
        OrganizationRepository organizationRepository = new OrganizationRepository();
        AuthenticationRepository authenticationRepository = new AuthenticationRepository();

        //Fill Task Category Repository
        TaskCategory taskCategoryOne = new TaskCategory("Task Category Description One");
        taskCategoryRepository.add(taskCategoryOne);

        TaskCategory taskCategoryTwo = new TaskCategory("Task Category Description Two");
        taskCategoryRepository.add(taskCategoryTwo);

        ArrayList<TaskCategory> expected = new ArrayList<TaskCategory>();
        expected.add(taskCategoryOne);
        expected.add(taskCategoryTwo);

        //Fill Organization Repository
        Organization organization = new Organization("123456789");
        Employee employee = new Employee("john.doe@this.company.com");
        organization.addEmployee(employee);
        organizationRepository.add(organization);

        //Add authentication for user john.doe@this.company.com
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserWithRole("Main Administrator", "john.doe@this.company.com", "admin",
                AuthenticationController.ROLE_ADMIN);

        authenticationRepository.doLogin("john.doe@this.company.com", "admin");

        CreateTaskController controller =
                new CreateTaskController(organizationRepository, taskCategoryRepository, authenticationRepository);

        //Act
        List<TaskCategory> taskCategories = controller.getTaskCategories();

        assertArrayEquals(expected.toArray(), taskCategories.toArray());
    }

    /**
     * Ensure create task works with singleton.
     */
    @Test
    void ensureCreateTaskWorksWithSingleton() {
        //Arrange
        //Get Repositories
        Repositories repositories = Repositories.getInstance();
        TaskCategoryRepository taskCategoryRepository = repositories.getTaskCategoryRepository();
        OrganizationRepository organizationRepository = repositories.getOrganizationRepository();
        AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();

        //Fill Task Category Repository
        TaskCategory taskCategory = new TaskCategory("Task Category Description");
        taskCategoryRepository.add(taskCategory);

        //Fill Organization Repository
        Organization organization = new Organization("123456789");
        Employee employee = new Employee("john.doe@this.company.com");
        organization.addEmployee(employee);
        organizationRepository.add(organization);

        Task expected = new Task("reference", "description", "informal description", "tecnical " + "description", 1, 1d,
                taskCategory, employee);

        //Add authentication for user john.doe@this.company.com
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserWithRole("Main Administrator", "john.doe@this.company.com", "admin",
                AuthenticationController.ROLE_ADMIN);

        authenticationRepository.doLogin("john.doe@this.company.com", "admin");

        CreateTaskController controller = new CreateTaskController();

        //Act
        Optional<Task> newTask =
                controller.createTask("reference", "description", "informal description", "tecnical " + "description",
                        1, 1d, "Task Category Description");

        //Assert
        assertEquals(expected, newTask.get());

    }

    //TODO: test the controller createTask using mockito to mock the repositories.

    /**
     * Ensure create task for non existing organization fails.
     */
    @Test
    void ensureCreateTaskForNonExistingOrganizationFails() {
        //Arrange
        //Get Repositories
        Repositories repositories = Repositories.getInstance();
        TaskCategoryRepository taskCategoryRepository = new TaskCategoryRepository();
        OrganizationRepository organizationRepository = new OrganizationRepository();
        AuthenticationRepository authenticationRepository = new AuthenticationRepository();

        //Fill Task Category Repository
        TaskCategory taskCategoryOne = new TaskCategory("Task Category Description");
        taskCategoryRepository.add(taskCategoryOne);

        TaskCategory taskCategoryTwo = new TaskCategory("Task Category Description Two");
        taskCategoryRepository.add(taskCategoryTwo);

        ArrayList<TaskCategory> expected = new ArrayList<TaskCategory>();
        expected.add(taskCategoryOne);
        expected.add(taskCategoryTwo);

        //Fill Organization Repository
        Organization organization = new Organization("123456789");
        Employee employee = new Employee("jane.doe@this.company.com");
        organization.addEmployee(employee);
        organizationRepository.add(organization);

        //Add authentication for user john.doe@this.company.com
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserWithRole("Main Administrator", "john.doe@this.company.com", "admin",
                AuthenticationController.ROLE_ADMIN);

        authenticationRepository.doLogin("john.doe@this.company.com", "admin");

        CreateTaskController controller =
                new CreateTaskController(organizationRepository, taskCategoryRepository, authenticationRepository);

        //Act
        Optional<Task> result =
                controller.createTask("reference", "description", "informal description", "tecnical " + "description",
                        1, 1d, "Task Category Description");

        assertTrue(result.isEmpty());
    }
}