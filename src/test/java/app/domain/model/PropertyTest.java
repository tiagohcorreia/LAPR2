package app.domain.model;

import app.domain.shared.SunExposure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    @DisplayName("Ensure House area <0 Fails")
    @Test
    void EnsureNegativePropertyAreaFails(){

        assertThrows(IllegalArgumentException.class, () -> {
            City city=new City("Porto");
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            equipment.add("sdifmoie");
            Property p1 = new House(35,city,23,photos,12,3,1,equipment,true,false,SunExposure.getSunExposureById(1));
            p1.setArea(-1);

        });
    }
    @DisplayName("Ensure House Distance of the center <0 Fails")
    @Test
    void EnsureNullHouseAreaFails(){

        assertThrows(IllegalArgumentException.class, () -> {
            City city=new City("Porto");
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            Property p1 = new House(35,city,23,photos,12,3,1,equipment,true,false,SunExposure.getSunExposureById(1));
            p1.setCityCentreDistance(-1);
        });
    }

    @DisplayName("Ensure House photographs array empty Fails")
    @Test
    void EnsureNullPhotosArrayFails(){

        assertThrows(NullPointerException.class, () -> {
            City city=new City("Porto");
            ArrayList<String> photos= new ArrayList<>();
            photos.add("sdifmoie");
            ArrayList<String> equipment= new ArrayList<>();
            photos.add("sdifmoie");
            Property p1 = new House(35,city,23,photos,12,3,1,equipment,true,false,SunExposure.getSunExposureById(1));
            p1.setPhotographs(null);
        });
    }


}