package pt.ipp.isep.dei.esoft.project.repository;

import app.domain.model.City;
import app.domain.model.District;
import app.domain.repository.DistrictRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DistrictRepositoryTest {
    private DistrictRepository districtRepository;

    @BeforeEach
    void setUp() {
        districtRepository = new DistrictRepository();
    }

    @Test
    void save() {
        City newYorkCity = new City("New York");
        District newYorkDistrict = new District("Manhattan", Arrays.asList(newYorkCity));
        districtRepository.save(newYorkDistrict);

        District foundDistrict = districtRepository.findByName("Manhattan");
        assertEquals(newYorkDistrict, foundDistrict);
    }

    @Test
    void findByName() {
        City newYorkCity = new City("New York");
        District newYorkDistrict = new District("Manhattan", Arrays.asList(newYorkCity));
        districtRepository.save(newYorkDistrict);

        District foundDistrict = districtRepository.findByName("Manhattan");
        assertEquals(newYorkDistrict, foundDistrict);
    }

    @Test
    void findByNameNotFound() {
        District foundDistrict = districtRepository.findByName("Nonexistent District");
        assertNull(foundDistrict);
    }

    @Test
    void findAll() {
        City newYorkCity = new City("New York");
        District newYorkDistrict = new District("Manhattan", Arrays.asList(newYorkCity));
        City losAngelesCity = new City("Los Angeles");
        District losAngelesDistrict = new District("Hollywood", Arrays.asList(losAngelesCity));

        districtRepository.save(newYorkDistrict);
        districtRepository.save(losAngelesDistrict);

        List<District> districts = districtRepository.findAll();
        assertEquals(2, districts.size());
        assertEquals(newYorkDistrict, districts.get(0));
        assertEquals(losAngelesDistrict, districts.get(1));
    }
}
