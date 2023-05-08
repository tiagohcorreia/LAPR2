package pt.ipp.isep.dei.esoft.project.domain.shared;

import java.util.List;

public interface InhabitableProperty {
    public int getNumberOfBedrooms();
    public int getNumberOfBathrooms();
    public int getNumberOfParkingSpaces();
    public List<String> getEquipment();

//    private int setNumberOfBedrooms(int numberOfBedrooms);
//    private int setNumberOfBathrooms(int numberOfBathrooms);
//    private int setNumberOfParkingSpaces(int numberOfParkingSpaces);
//    private List<String> setEquipment(List<String> equipment);
}
