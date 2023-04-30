package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

/**
 * The type Task.
 */
public class Task {
    private final String reference;
    private final String description;
    private final String informalDescription;
    private final String technicalDescription;
    private final Integer duration;
    private final Double cost;

    private final TaskCategory taskCategory;

    private final Employee employee;

    /**
     * Instantiates a new Task.
     *
     * @param reference            the reference
     * @param description          the description
     * @param informalDescription  the informal description
     * @param technicalDescription the technical description
     * @param duration             the duration
     * @param cost                 the cost
     * @param taskCategory         the task category
     * @param employee             the employee
     */
    public Task(String reference, String description, String informalDescription, String technicalDescription,
                Integer duration, Double cost, TaskCategory taskCategory, Employee employee) {

        validateReference(reference);
        this.reference = reference;
        this.description = description;
        this.informalDescription = informalDescription;
        this.technicalDescription = technicalDescription;
        this.duration = duration;
        this.cost = cost;
        this.taskCategory = taskCategory;
        this.employee = employee;
    }

    private void validateReference(String reference) {
        //TODO: missing from the diagrams
        if (reference == null || reference.isEmpty()) {
            throw new IllegalArgumentException("Reference cannot be null or empty.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Task)) {
            return false;
        }
        Task task = (Task) o;
        return reference.equals(task.reference) && employee.equals(task.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, employee);
    }


    public Task clone() {
        return new Task(this.reference, this.description, this.informalDescription, this.technicalDescription,
                this.duration, this.cost, this.taskCategory, this.employee);
    }

}
