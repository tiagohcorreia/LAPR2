package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.Branch;
import pt.ipp.isep.dei.esoft.project.domain.model.Location;
import pt.ipp.isep.dei.esoft.project.domain.shared.GenericRepository;
import pt.ipp.isep.dei.esoft.project.exceptions.DuplicateDataException;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Register branch repository.
 */
public class BranchRepository{

    List<Branch> branches = new ArrayList<>();


    /**
     * Save branch.
     *
     * @param branch the branch
     */
    public boolean saveBranch(Branch branch){
        if (findBranch(branch) != -1)
            throw new DuplicateDataException("This branch is already registered in the system at position "
                    + findBranch(branch));
        //System.out.println("Saving branch...");
        //does nothing for now
        branches.add(branch);
        return true;
    }

    public int findBranch(Branch branch){
        for (Branch thisBranch: branches) {
            if(branch.equals(thisBranch) || branch.getName().equals(thisBranch.getName()))
                return branches.indexOf(thisBranch);
        }
        return -1;
    }

    public Branch create(List<?> objects) {
        Branch branch = new Branch();
        return branch;
    }

    public Branch createBranch(int id, String name, Location location, int phoneNumber, String email){
        return new Branch(id, name, location, phoneNumber, email);
    }

    public boolean save(Branch branch) {
        if(validate(branch))
            return branches.add(branch);

        return false;
    }

    /**
     * Checks if a branch has already been added.
     *
     * @return True if the new branch is valid, False otherwise
     */
    public boolean validate(Branch branch) {
        return (indexOf(branch) == -1);
    }

    public int indexOf(Branch branch) {
        for (Branch thisBranch: branches) {
            if(branch.equals(thisBranch) || branch.getName().equals(thisBranch.getName()))
                return branches.indexOf(thisBranch);
        }
        return -1;
    }

    private int getLowestAvailableID(){
        int lowestID = 0;
        for (Branch branch:
             branches) {
            if (branch.getID()>lowestID)
                lowestID = branch.getID();
        }
        lowestID++;
        return lowestID;
    }

}
