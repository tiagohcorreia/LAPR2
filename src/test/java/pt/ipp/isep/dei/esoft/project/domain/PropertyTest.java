package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.domain.model.Location;
import pt.ipp.isep.dei.esoft.project.domain.shared.SunExposure;
import pt.ipp.isep.dei.esoft.project.domain.model.Property;
import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.model.House;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Property test.
 */
class PropertyTest {

    /**
     * Ensure negative property area fails.
     */
    @DisplayName("Ensure House area <0 Fails")
    @Test
    void EnsureNegativePropertyAreaFails(){

        assertThrows(IllegalArgumentException.class, () -> {
            //City city=new City("Porto");
            Location location = new Location();
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            equipment.add("sdifmoie");
            Property p1 = new House(35,location,23,photos,12,3,1,equipment,true,false,SunExposure.getSunExposureById(1));
            p1.setArea(-1);

        });
    }

    /**
     * Ensure null house area fails.
     */
    @DisplayName("Ensure House Distance of the center <0 Fails")
    @Test
    void EnsureNullHouseAreaFails(){

        assertThrows(IllegalArgumentException.class, () -> {
            //City city=new City("Porto");
            Location location = new Location();
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            Property p1 = new House(35,location,23,photos,12,3,1,equipment,true,false,SunExposure.getSunExposureById(1));
            p1.setCityCentreDistance(-1);
        });
    }

    /**
     * Ensure null photos array fails.
     */
    @DisplayName("Ensure House photographs array empty Fails")
    @Test
    void EnsureNullPhotosArrayFails(){

        assertThrows(NullPointerException.class, () -> {
            //City city=new City("Porto");
            Location location = new Location();ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            Property p1 = new House(35,location,23,photos,12,3,1,equipment,true,false,SunExposure.getSunExposureById(1));
            p1.setPhotographs(null);
        });
    }

    /**
     * Ensure limits photos array fails.
     */
    @DisplayName("Ensure House photographs array bigger than 30 Fails")
    @Test
    void EnsureLimitsPhotosArrayFails(){

        assertThrows(IllegalArgumentException.class, () -> {
            //City city=new City("Porto");
            Location location = new Location();
            ArrayList<String> photos= new ArrayList<>();
            photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");
            photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");photos.add("a");
            ArrayList<String> equipment= new ArrayList<>();
            Property p1 = new House(35,location,23,photos,12,3,1,equipment,true,false,SunExposure.getSunExposureById(1));

        });
    }

}