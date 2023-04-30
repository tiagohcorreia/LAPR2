package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * The type Organization.
 */
public class Organization {
    private final String vatNumber;
    /**
     * The Employees.
     */
    List<Employee> employees = new ArrayList<>();
    /**
     * The Tasks.
     */
    List<Task> tasks = new ArrayList<>();
    private String name;
    private String website;
    private String phone;
    private String email;

    /**
     * Instantiates a new Organization.
     *
     * @param vatNumber the vat number
     */
    public Organization(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    /**
     * Employs boolean.
     *
     * @param employee the employee
     * @return the boolean
     */
    public boolean employs(Employee employee) {
        return employees.contains(employee);
    }

    /**
     * Create task optional.
     *
     * @param reference            the reference
     * @param description          the description
     * @param informalDescription  the informal description
     * @param technicalDescription the technical description
     * @param duration             the duration
     * @param cost                 the cost
     * @param taskCategory         the task category
     * @param employee             the employee
     * @return the optional
     */
    public Optional<Task> createTask(String reference, String description, String informalDescription,
                                     String technicalDescription, Integer duration, Double cost,
                                     TaskCategory taskCategory, Employee employee) {

        //TODO: we could also check if the employee works for the organization before proceeding
        //checkIfEmployeeWorksForOrganization(employee);

        // When a Task is added, it should fail if the Task already exists in the list of Tasks.
        // In order to not return null if the operation fails, we use the Optional class.
        Optional<Task> optionalValue = Optional.empty();

        Task task = new Task(reference, description, informalDescription, technicalDescription, duration, cost,
                taskCategory, employee);

        if (addTask(task)) {
            optionalValue = Optional.of(task);
        }
        return optionalValue;
    }

    private boolean addTask(Task task) {
        boolean success = false;
        if (validate(task)) {
            // A clone of the task is added to the list of tasks, to avoid side effects and outside manipulation.
            success = tasks.add(task.clone());
        }
        return success;

    }

    private boolean validate(Task task) {
        return tasksDoNotContain(task);
    }

    private boolean tasksDoNotContain(Task task) {
        return !tasks.contains(task);
    }

    /**
     * Any employee has email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public boolean anyEmployeeHasEmail(String email) {
        boolean result = false;
        for (Employee employee : employees) {
            if (employee.hasEmail(email)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Organization)) {
            return false;
        }
        Organization that = (Organization) o;
        return vatNumber.equals(that.vatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vatNumber);
    }

    /**
     * Add employee boolean.
     *
     * @param employee the employee
     * @return the boolean
     */
//add employee to organization
    public boolean addEmployee(Employee employee) {
        boolean success = false;
        if (validateEmployee(employee)) {
            success = employees.add(employee);
        }
        return success;
    }

    private boolean validateEmployee(Employee employee) {
        return employeesDoNotContain(employee);
    }

    private boolean employeesDoNotContain(Employee employee) {
        return !employees.contains(employee);
    }

    //Clone organization
    public Organization clone() {
        Organization clone = new Organization(this.vatNumber);
        clone.name = (this.name);
        clone.website = (this.website);
        clone.phone = (this.phone);
        clone.email = (this.email);

        for (Employee in : this.employees) {
            clone.employees.add(in.clone());
        }


        for (Task in : this.tasks) {
            clone.tasks.add(in.clone());
        }


        return clone;
    }
}
