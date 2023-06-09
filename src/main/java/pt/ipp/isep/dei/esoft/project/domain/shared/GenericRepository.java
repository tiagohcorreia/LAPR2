package pt.ipp.isep.dei.esoft.project.domain.shared;

import pt.ipp.isep.dei.esoft.project.exceptions.DuplicateDataException;

import java.util.List;

public abstract class GenericRepository<T> {
    private List<T> elements;

    public boolean isValid(T element){
        for (T e: elements) {
            if (e.equals(element))
                throw new DuplicateDataException("Element is duplicate");
        }
        return true;
    }

    public boolean save(T element){
        isValid(element);
        return elements.add(element);
    }
}
