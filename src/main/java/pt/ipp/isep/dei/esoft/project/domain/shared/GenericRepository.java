package pt.ipp.isep.dei.esoft.project.domain.shared;

import pt.ipp.isep.dei.esoft.project.exceptions.DuplicateDataException;

import java.util.List;

/**
 * The type Generic repository.
 *
 * @param <T> the type parameter
 */
public abstract class GenericRepository<T> {
    private List<T> elements;

    /**
     * Is valid boolean.
     *
     * @param element the element
     * @return the boolean
     */
    public boolean isValid(T element){
        for (T e: elements) {
            if (e.equals(element))
                throw new DuplicateDataException("Element is duplicate");
        }
        return true;
    }

    /**
     * Save boolean.
     *
     * @param element the element
     * @return the boolean
     */
    public boolean save(T element){
        isValid(element);
        return elements.add(element);
    }
}
