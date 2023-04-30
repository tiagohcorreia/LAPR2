package pt.ipp.isep.dei.esoft.project.application.controller;



import pt.ipp.isep.dei.esoft.project.domain.model.Branch;
import pt.ipp.isep.dei.esoft.project.domain.repository.RegisterBranchRepository;

/**
 * The type Register branch controller.
 */
public class RegisterBranchController {

    private RegisterBranchRepository branchRepository;

    /**
     * Instantiates a new Register branch controller.
     *
     * @param branchRepo the branch repo
     */
    public RegisterBranchController(RegisterBranchRepository branchRepo) {
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
    public String createBranch(int ID, String name, String location, int phoneNumber,  String email) {

        Branch newBranch = new Branch(ID, name, location, phoneNumber, email);

        try {

            branchRepository.saveBranch(newBranch);

            return newBranch.toString();

        } catch (Exception e) {

            throw new IllegalStateException(e.getMessage().toString());
        }


    }

}
