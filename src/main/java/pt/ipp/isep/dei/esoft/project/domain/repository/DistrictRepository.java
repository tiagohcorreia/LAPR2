package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.model.District;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type District repository.
 */
public class DistrictRepository {
    private static List<District> districts = new ArrayList<>();

    /**
     * Save.
     *
     * @param district the district
     */
    public void save(District district) {
        if (districtIsValid(district)) {
            districts.add(district);
        }
    }

    /**
     * Find by name district.
     *
     * @param name the name
     * @return the district
     */
    public District findByName(String name) {
        for (District district : districts) {
            if (district.getName().equalsIgnoreCase(name)) {
                return district;
            }
        }
        return null;
    }

    private boolean districtIsValid(District district) {
        return district != null && !districts.contains(district);
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<District> findAll() {
        return new ArrayList<>(districts);
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return districts.isEmpty();
    }

    /**
     * Add city.
     *
     * @param districtName the district name
     * @param city         the city
     */
    public void addCity(String districtName, City city) {
        District district = findByName(districtName);
        if (district != null && city != null && !district.getCities().contains(city)) {
            district.getCities().add(city);
        }
    }

    public void readObject() {

        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ser/district.ser"));
            districts = (List<District>) ois.readObject();
            System.out.println(districts);
            ois.close();

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();
        }
    }

    /**
     * Write object.
     */
    public void writeObject() {

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ser/district.ser"));
            oos.writeObject(districts);
            oos.close();

        } catch (IOException ioe) {

            ioe.printStackTrace();
        }
    }
}

