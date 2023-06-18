package pt.ipp.isep.dei.esoft.project.domain.shared;

import java.util.List;

/**
 * The interface Inhabitable property.
 */
public interface InhabitableProperty {
    /**
     * Gets number of bedrooms.
     *
     * @return the number of bedrooms
     */
    public int getNumberOfBedrooms();

    /**
     * Gets number of bathrooms.
     *
     * @return the number of bathrooms
     */
    public int getNumberOfBathrooms();

    /**
     * Gets number of parking spaces.
     *
     * @return the number of parking spaces
     */
    public int getNumberOfParkingSpaces();

    /**
     * Gets equipment.
     *
     * @return the equipment
     */
    public List<String> getEquipment();

//    private int setNumberOfBedrooms(int numberOfBedrooms);
//    private int setNumberOfBathrooms(int numberOfBathrooms);
//    private int setNumberOfParkingSpaces(int numberOfParkingSpaces);
//    private List<String> setEquipment(List<String> equipment);
}
