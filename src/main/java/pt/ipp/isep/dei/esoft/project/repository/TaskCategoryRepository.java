package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.TaskCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Task category repository.
 */
public class TaskCategoryRepository {

    private final List<TaskCategory> taskCategories = new ArrayList<>();

    /**
     * Gets task category by description.
     *
     * @param taskCategoryDescription the task category description
     * @return the task category by description
     */
    public TaskCategory getTaskCategoryByDescription(String taskCategoryDescription) {
        TaskCategory newTaskCategory = new TaskCategory(taskCategoryDescription);
        TaskCategory taskCategory = null;
        if (taskCategories.contains(newTaskCategory)) {
            taskCategory = taskCategories.get(taskCategories.indexOf(newTaskCategory));
        }
        if (taskCategory == null) {
            throw new IllegalArgumentException(
                    "Task Category requested for [" + taskCategoryDescription + "] does not exist.");
        }
        return taskCategory;
    }

    /**
     * Add optional.
     *
     * @param taskCategory the task category
     * @return the optional
     */
    public Optional<TaskCategory> add(TaskCategory taskCategory) {

        Optional<TaskCategory> newTaskCategory = Optional.empty();
        boolean operationSuccess = false;

        if (validateTaskCategory(taskCategory)) {
            newTaskCategory = Optional.of(taskCategory.clone());
            operationSuccess = taskCategories.add(newTaskCategory.get());
        }

        if (!operationSuccess) {
            newTaskCategory = Optional.empty();
        }

        return newTaskCategory;
    }

    private boolean validateTaskCategory(TaskCategory taskCategory) {
        boolean isValid = !taskCategories.contains(taskCategory);
        return isValid;
    }

    /**
     * Gets task categories.
     *
     * @return the task categories
     */
    public List<TaskCategory> getTaskCategories() {
        //This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(taskCategories);
    }
}
