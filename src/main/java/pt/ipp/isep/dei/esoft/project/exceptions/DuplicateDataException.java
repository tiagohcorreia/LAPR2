package pt.ipp.isep.dei.esoft.project.exceptions;

public class DuplicateDataException extends IllegalArgumentException{
    public DuplicateDataException(String message){
        super(message);
    }
}
