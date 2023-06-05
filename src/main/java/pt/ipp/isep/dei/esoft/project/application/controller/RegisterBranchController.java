package pt.ipp.isep.dei.esoft.project.application.controller;



import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.repository.*;

import java.util.ArrayList;

/**
 * The type Register branch controller.
 */
public class RegisterBranchController {

    BranchRepository branchRepository = Repositories.getInstance().getBranchRepository();
    CityRepository cityRepository = Repositories.getInstance().getCityRepository();
    StateRepository stateRepository = Repositories.getInstance().getStateRepository();
    DistrictRepository districtRepository = Repositories.getInstance().getDistrictRepository();


    /**
     * Instantiates a new Register branch controller.
     *
     * @param branchRepo the branch repo
     */
    public RegisterBranchController(BranchRepository branchRepo) {
        branchRepository = branchRepo;
    }

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
    public Branch createBranch(int id, String name, Location location, int phoneNumber, String email) {

        //Branch newBranch = new Branch(ID, name, location, phoneNumber, email);
        Branch newBranch = branchRepository.createBranch(id, name, location, phoneNumber, email);

        try {
            branchRepository.saveBranch(newBranch);
            branchRepository.writeObject();
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }

        return newBranch;
    }

    public Location createLocation(String doorNumberString, String street, String cityString, String districtString, String stateString, String zipCodeString){
        int doorNumber = Integer.parseInt(doorNumberString);
        int zipCode = Integer.parseInt(zipCodeString);

        City city = cityRepository.findByName(cityString);
        District district = districtRepository.findByName(districtString);
        State state = stateRepository.findByName(stateString);

        if (state == null){
            state = stateRepository.createState(stateString);
            stateRepository.save(state);

            district = new District(districtString, new ArrayList<>());
            districtRepository.save(district);
            stateRepository.addDistrictToState(state, district);

            city = cityRepository.createCity(stateString);
            cityRepository.save(city);
            districtRepository.addCity(districtString, city);
        } else if (district == null){
            district = new District(districtString, new ArrayList<>());
            districtRepository.save(district);
            stateRepository.addDistrictToState(state, district);

            city = cityRepository.createCity(stateString);
            cityRepository.save(city);
            districtRepository.addCity(districtString, city);
        } else if(city == null){
            city = cityRepository.createCity(stateString);
            cityRepository.save(city);
            districtRepository.addCity(districtString, city);
        }

        return new Location(doorNumber, street, city, district, state, zipCode);
    }

    public boolean saveBranch(Branch branch){
       return branchRepository.saveBranch(branch);
    }

}
