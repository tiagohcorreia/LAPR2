package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.model.District;
import pt.ipp.isep.dei.esoft.project.domain.repository.DistrictRepository;

import java.util.ArrayList;
import java.util.List;

public class DistrictController {
    private DistrictRepository districtRepository;

    public DistrictController(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public void addDistrict(String name) {
        District district = new District(name, new ArrayList<>());
        districtRepository.save(district);
    }

    public District findDistrictByName(String name) {
        return districtRepository.findByName(name);
    }
    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }
    public void addCityToDistrict(String districtName, City city) {
        districtRepository.addCity(districtName, city);
    }

}
