package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.Branch;
import pt.ipp.isep.dei.esoft.project.exceptions.DuplicateDataException;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Register branch repository.
 */
public class BranchRepository {

    List<Branch> branches = new ArrayList<>();


    /**
     * Save branch.
     *
     * @param branch the branch
     */
    public boolean saveBranch(Branch branch){
        if (branchExists(branch))
            throw new DuplicateDataException("This branch is already registered in the system");
        //System.out.println("Saving branch...");
        //does nothing for now
        branches.add(branch);
        return true;
    }

    public boolean branchExists(Branch branch){
        for (Branch thisBranch: branches) {
            if(branch.equals(thisBranch) || branch.getName().equals(thisBranch.getName()))
                return true;
        }
        return false;
    }
}
