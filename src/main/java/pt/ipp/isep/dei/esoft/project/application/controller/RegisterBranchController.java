package pt.ipp.isep.dei.esoft.project.application.controller;



import pt.ipp.isep.dei.esoft.project.domain.model.*;
import pt.ipp.isep.dei.esoft.project.domain.repository.*;

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
     * @param ID          the id
     * @param name        the name
     * @param location    the location
     * @param phoneNumber the phone number
     * @param email       the email
     * @return the string
     */
    public String createBranch(int ID, String name, Location location, int phoneNumber, String email) {

        Branch newBranch = new Branch(ID, name, location, phoneNumber, email);

        try {

            branchRepository.saveBranch(newBranch);
            branchRepository.writeObject();

            return newBranch.toString();

        } catch (Exception e) {

            throw new IllegalStateException(e.getMessage().toString());
        }


    }

    public Location createLocation(String doorNumber, String street, String cityString, String districtString, String stateString, String zipCode){
        int dn = Integer.parseInt(doorNumber);
        int zc = Integer.parseInt(zipCode);

        City city = cityRepository.findByName(cityString);
        District district = districtRepository.findByName(districtString);
        State state = stateRepository.findByName(stateString);

        /*if (state == null){
            state = createState(stateString);
        }
        if (district == null){
            state = cre(stateString);
        }
        if (state == null){
            state = createState(stateString);
        }
    */



        return new Location(dn, street, city, district, state, zc);
    }


}
