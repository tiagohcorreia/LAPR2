package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.model.House;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type House test.
 */
class HouseTest {

    /**
     * Ensure negative house bedrooms fails.
     */
    @DisplayName("Ensure that number of bedrooms <0 Fails")
    @Test
    void EnsureNegativeHouseBedroomsFails(){

        assertThrows(IllegalArgumentException.class, () -> {
            City city=new City("Porto");
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            House p1 = new House(35,city,23,photos,12,3,1,equipment,true,false, SunExposure.getSunExposureById(1));
            p1.setNumberOfBedrooms(-1);
        });
    }

    /**
     * Ensure negative house bathrooms fails.
     */
    @DisplayName("Ensure that number of bathrooms <0 Fails")
    @Test
    void EnsureNegativeHouseBathroomsFails(){

        assertThrows(IllegalArgumentException.class, () -> {
            City city=new City("Porto");
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            House p1 = new House(35,city,23,photos,12,3,1,equipment,true,false, SunExposure.getSunExposureById(1));
            p1.setNumberOfBathrooms(-1);
        });
    }

    /**
     * Ensure negative house parking spaces fails.
     */
    @DisplayName("Ensure that number of parking spaces <0 Fails")
    @Test
    void EnsureNegativeHouseParkingSpacesFails(){

        assertThrows(IllegalArgumentException.class, () -> {
            City city=new City("Porto");
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            House p1 = new House(35,city,23,photos,12,3,1,equipment,true,false, SunExposure.getSunExposureById(1));
            p1.setNumberOfParkingSpaces(-1);
        });
    }

    /**
     * Ensure null house equipment fails.
     */
    @DisplayName("Ensure that null equipment Fails")
    @Test
    void EnsureNullHouseEquipmentFails(){

        assertThrows(NullPointerException.class, () -> {
            City city=new City("Porto");
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            House p1 = new House(35,city,23,photos,12,3,1,equipment,true,false,SunExposure.getSunExposureById(1));
            p1.setEquipment(null);
        });
    }

}