package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.Branch;
import pt.ipp.isep.dei.esoft.project.domain.model.Location;
import pt.ipp.isep.dei.esoft.project.exceptions.DuplicateDataException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Register branch repository.
 */
public class BranchRepository implements Serializable {

    /**
     * The constant branches.
     */
    public static List<Branch> branches = new ArrayList<>();

    /**
     * Save branch.
     *
     * @param branch the branch
     * @return the boolean
     */
    public boolean saveBranch(Branch branch) {

        if (validate(branch)) {

            return addBranch(branch);
        }
        return false;
    }

    /**
     * Add branch boolean.
     *
     * @param branch the branch
     * @return the boolean
     */
    public boolean addBranch(Branch branch) {

        if (branch != null && validate(branch)) {

            return branches.add(branch);
        }
        return false;
    }

    /**
     * Validate boolean.
     *
     * @param branch the branch
     * @return the boolean
     */
    public boolean validate(Branch branch) {

        for(Branch branch1 : branches) {

            if(branch1.equals(branch)) {

                throw new DuplicateDataException("Branch is already registered");
            }
        }
        return true;
    }

    /**
     * Find branch int.
     *
     * @param branch the branch
     * @return the int
     */
    public int findBranch(Branch branch) {
        for (Branch thisBranch : branches) {
            if (branch.equals(thisBranch) || branch.getName().equals(thisBranch.getName()))
                return branches.indexOf(thisBranch);
        }
        return -1;
    }

    /**
     * Create branch.
     *
     * @param objects the objects
     * @return the branch
     */
    public Branch create(List<?> objects) {
        Branch branch = new Branch();
        return branch;
    }

    /**
     * Create branch branch.
     *
     * @param id          the id
     * @param name        the name
     * @param location    the location
     * @param phoneNumber the phone number
     * @param email       the email
     * @return the branch
     */
    public Branch createBranch(int id, String name, Location location, String phoneNumber, String email) {
        return new Branch(id, name, location, phoneNumber, email);
    }


    /**
     * Checks if a branch has already been added.
     *
     * @param branch the branch
     * @return True if the new branch is valid, False otherwise
     */
    public int indexOf(Branch branch) {
        for (Branch thisBranch : branches) {
            if (branch.equals(thisBranch) || branch.getName().equals(thisBranch.getName()))
                return branches.indexOf(thisBranch);
        }
        return -1;
    }

    private int getLowestAvailableID() {
        int lowestID = 0;
        for (Branch branch :
                branches) {
            if (branch.getID() > lowestID)
                lowestID = branch.getID();
        }
        lowestID++;
        return lowestID;
    }

    /**
     * Gets branch list.
     *
     * @return the branch list
     */
    public List<Branch> getBranchList() {

        return new ArrayList<>(branches);
    }

    /**
     * Gets branch by id.
     *
     * @param id the id
     * @return the branch by id
     */
    public static Branch getBranchByID(int id) {

        if (id >= 0 && id < branches.size()) {

            return branches.get(id);
        }
        return null;
    }

    /**
     * Read object list.
     *
     * @return the list
     */
    public List<Branch> readObject() {

        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ser/branch.ser"));
            branches = (List<Branch>) ois.readObject();
            ois.close();

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();
        }
        return branches;
    }

    /**
     * Write object.
     */
    public void writeObject() {

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ser/branch.ser"));
            oos.writeObject(branches);
            oos.close();

        } catch (IOException ioe) {

            ioe.printStackTrace();
        }
    }

}
