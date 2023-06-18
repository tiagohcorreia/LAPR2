package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.repository.*;

import java.util.ArrayList;

/**
 * The type Register branch controller.
 */
public class RegisterBranchController {

    /**
     * The Branch repository.
     */
    BranchRepository branchRepository = Repositories.getInstance().getBranchRepository();
    /**
     * The City repository.
     */
    CityRepository cityRepository = Repositories.getInstance().getCityRepository();
    /**
     * The State repository.
     */
    StateRepository stateRepository = Repositories.getInstance().getStateRepository();
    /**
     * The District repository.
     */
    DistrictRepository districtRepository = Repositories.getInstance().getDistrictRepository();


    /**
     * Instantiates a new Register branch controller.
     *
     * @param branchRepo the branch repo
     */


    /**
     * Create branch string.
     *
     * @param id          the id
     * @param name        the name
     * @param location    the location
     * @param phoneNumber the phone number
     * @param email       the email
     * @return the string
     */
    public Branch createBranch(int id, String name, Location location, String phoneNumber, String email) {

        Branch newBranch = branchRepository.createBranch(id, name, location, phoneNumber, email);

        try {

            this.branchRepository.saveBranch(newBranch);
            this.branchRepository.writeObject();
            System.out.println();

        } catch (Exception e) {

            throw new IllegalStateException(e.getMessage());
        }
        return newBranch;
    }

    /**
     * Create location location.
     *
     * @param doorNumberString the door number string
     * @param street           the street
     * @param cityString       the city string
     * @param districtString   the district string
     * @param stateString      the state string
     * @param zipCodeString    the zip code string
     * @return the location
     */
    public Location createLocation(String doorNumberString, String street, String cityString, String districtString, String stateString, String zipCodeString) {

        int doorNumber = Integer.parseInt(doorNumberString);
        int zipCode = Integer.parseInt(zipCodeString);

        State state = stateRepository.findByName(stateString);
        District district = districtRepository.findByName(districtString);
        City city = cityRepository.findByName(cityString);

        if (state == null) {

            state = stateRepository.createState(stateString);
            stateRepository.save(state);

            district = new District(districtString, new ArrayList<>());
            districtRepository.save(district);
            stateRepository.addDistrictToState(state, district);

            city = cityRepository.createCity(stateString);
            cityRepository.save(city);
            districtRepository.addCity(districtString, city);

        } else if (district == null) {

            district = new District(districtString, new ArrayList<>());
            districtRepository.save(district);
            stateRepository.addDistrictToState(state, district);

            city = cityRepository.createCity(stateString);
            cityRepository.save(city);
            districtRepository.addCity(districtString, city);

        } else if (city == null) {

            city = cityRepository.createCity(stateString);
            cityRepository.save(city);
            districtRepository.addCity(districtString, city);
        }
        return new Location(doorNumber, street, city, district, state, zipCode);
    }

}
