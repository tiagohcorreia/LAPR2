package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

/**
 * The type Task category.
 */
public class TaskCategory {

    private final String description;

    /**
     * Instantiates a new Task category.
     *
     * @param description the description
     */
    public TaskCategory(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TaskCategory)) {
            return false;
        }
        TaskCategory that = (TaskCategory) o;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    public TaskCategory clone() {
        return new TaskCategory(this.description);
    }
}
