package pt.ipp.isep.dei.esoft.project.domain.shared;

import pt.ipp.isep.dei.esoft.project.exceptions.DuplicateDataException;

import java.util.List;

public abstract class GenericRepository<T> {
    private List<T> elements;

    public boolean add(T element){
        validate(element);
        return elements.add(element);
    }

    public boolean validate(T element){
        for (T e: elements) {
            if (e.equals(element))
                throw new DuplicateDataException("Element is duplicate");
        }
        return true;
    }




}
