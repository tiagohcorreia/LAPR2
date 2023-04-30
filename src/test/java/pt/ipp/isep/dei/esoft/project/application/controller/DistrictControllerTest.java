package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.controller.DistrictController;
import pt.ipp.isep.dei.esoft.project.domain.model.District;
import pt.ipp.isep.dei.esoft.project.domain.repository.DistrictRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * The type District controller test.
 */
class DistrictControllerTest {
    private DistrictRepository districtRepository;
    private DistrictController districtController;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        districtRepository = Mockito.mock(DistrictRepository.class);
        districtController = new DistrictController(districtRepository);
    }

    /**
     * Add district.
     */
    @Test
    void addDistrict() {
        String districtName = "Manhattan";
        districtController.addDistrict(districtName);

        District district = new District(districtName, new ArrayList<>());
        verify(districtRepository, times(1)).save(district);
    }

    /**
     * Find district by name.
     */
    @Test
    void findDistrictByName() {
        District manhattan = new District("Manhattan", new ArrayList<>());
        when(districtRepository.findByName("Manhattan")).thenReturn(manhattan);

        District foundDistrict = districtController.findDistrictByName("Manhattan");
        assertEquals(manhattan, foundDistrict);
    }

    /**
     * Gets all districts.
     */
    @Test
    void getAllDistricts() {
        List<District> districts = new ArrayList<>(Arrays.asList(
                new District("Manhattan", new ArrayList<>()),
                new District("Brooklyn", new ArrayList<>()),
                new District("Queens", new ArrayList<>())
        ));
        when(districtRepository.findAll()).thenReturn(districts);

        List<District> allDistricts = districtController.getAllDistricts();
        assertEquals(districts, allDistricts);
    }
}
