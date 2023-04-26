package app.controller;

import app.domain.model.City;
import app.domain.model.District;
import app.domain.repository.DistrictRepository;

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
