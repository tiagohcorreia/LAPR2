package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.model.District;
import pt.ipp.isep.dei.esoft.project.domain.repository.DistrictRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * The type District controller.
 */
public class DistrictController {
    private DistrictRepository districtRepository;

    /**
     * Instantiates a new District controller.
     *
     * @param districtRepository the district repository
     */
    public DistrictController(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    /**
     * Add district.
     *
     * @param name the name
     */
    public void addDistrict(String name) {
        District district = new District(name, new ArrayList<>());
        districtRepository.save(district);
        districtRepository.writeObject();
    }

    /**
     * Find district by name district.
     *
     * @param name the name
     * @return the district
     */
    public District findDistrictByName(String name) {
        return districtRepository.findByName(name);
    }

    /**
     * Gets all districts.
     *
     * @return the all districts
     */
    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }

    /**
     * Add city to district.
     *
     * @param districtName the district name
     * @param city         the city
     */
    public void addCityToDistrict(String districtName, City city) {
        districtRepository.addCity(districtName, city);
    }

}
