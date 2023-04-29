package pt.ipp.isep.dei.esoft.project.application.controller;



import pt.ipp.isep.dei.esoft.project.domain.model.Branch;
import pt.ipp.isep.dei.esoft.project.domain.repository.RegisterBranchRepository;

public class RegisterBranchController {

    private RegisterBranchRepository branchRepository;

    public RegisterBranchController(RegisterBranchRepository branchRepo) {
        branchRepository = branchRepo;
    }

    /**
     *
     * @param ID
     * @param name
     * @param location
     * @param phoneNumber
     * @param email
     * @return
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
