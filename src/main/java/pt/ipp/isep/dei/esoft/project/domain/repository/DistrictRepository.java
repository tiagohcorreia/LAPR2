package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.model.District;

import java.util.ArrayList;
import java.util.List;

public class DistrictRepository {
    private List<District> districts = new ArrayList<>();

    public void save(District district) {
        if (districtIsValid(district)) {
            districts.add(district);
        }
    }

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

    public List<District> findAll() {
        return new ArrayList<>(districts);
    }

    public boolean isEmpty() {
        return districts.isEmpty();
    }

    public void addCity(String districtName, City city) {
        District district = findByName(districtName);
        if (district != null && city != null && !district.getCities().contains(city)) {
            district.getCities().add(city);
        }
    }
}

