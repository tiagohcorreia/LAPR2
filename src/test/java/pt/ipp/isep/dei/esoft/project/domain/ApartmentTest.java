package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.domain.model.Location;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.model.Apartment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Apartment test.
 */
class ApartmentTest {
    /**
     * Ensure negative apartment bedrooms fails.
     */
    @DisplayName("Ensure that number of bedrooms <0 Fails")
    @Test
    void EnsureNegativeApartmentBedroomsFails(){

        assertThrows(IllegalArgumentException.class, () -> {
            //City city=new City("Porto");
            Location location = new Location();
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            Apartment p1 = new Apartment(35,location,23,photos,12,3,1,equipment);
            p1.setNumberOfBedrooms(-1);
        });
    }

    /**
     * Ensure negative apartment bathrooms fails.
     */
    @DisplayName("Ensure that number of bathrooms <0 Fails")
    @Test
    void EnsureNegativeApartmentBathroomsFails(){

        assertThrows(IllegalArgumentException.class, () -> {
            //City city=new City("Porto");
            Location location = new Location();
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            Apartment p1 = new Apartment(35,location,23,photos,12,3,1,equipment);
            p1.setNumberOfBathrooms(-1);
        });
    }

    /**
     * Ensure negative apartment parking spaces fails.
     */
    @DisplayName("Ensure that number of parking spaces <0 Fails")
    @Test
    void EnsureNegativeApartmentParkingSpacesFails(){

        assertThrows(IllegalArgumentException.class, () -> {
            //City city=new City("Porto");
            Location location = new Location();
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            Apartment p1 = new Apartment(35,location,23,photos,12,3,1,equipment);
            p1.setNumberOfParkingSpaces(-1);
        });
    }

    /**
     * Ensure null apartment equipment fails.
     */
    @DisplayName("Ensure that null equipment Fails")
    @Test
    void EnsureNullApartmentEquipmentFails(){

        assertThrows(NullPointerException.class, () -> {
            //City city=new City("Porto");
            Location location = new Location();
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            Apartment p1 = new Apartment(35,location,23,photos,12,3,1,equipment);
            p1.setEquipment(null);
        });
    }
}