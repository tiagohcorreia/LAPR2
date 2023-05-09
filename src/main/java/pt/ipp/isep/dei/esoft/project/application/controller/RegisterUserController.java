package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.model.User;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.repository.UserRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
//import pt.isep.lei.esoft.auth.AuthFacade;

import javax.management.InvalidAttributeValueException;
import java.util.List;

public class RegisterUserController {
    private AuthenticationRepository authenticationRepository = pt.ipp.isep.dei.esoft.project.repository.Repositories.getInstance().getAuthenticationRepository();
    private UserRepository userRepository = Repositories.getInstance().getUserRepository();
    //private AuthFacade authFacade = new AuthFacade();

    public User createUser(List<String> input) {
        User newUser = null;
        try {
            newUser = new User(input);
        } catch (Exception e){
            System.out.println("Couldn't create user. " + e.getMessage());
        }
        return newUser;
    }

    public boolean addUser(User newUser){
        boolean success = false;
        try {
             success = userRepository.add(newUser);
        } catch (Exception e) {
            System.out.println("Couldn't save user: " + e.getMessage());
        }
        //authFacade.addUserWithRole(newUser.getName(), newUser.getEmail(), newUser.getPassword(), AuthenticationController.ROLE_CLIENT);
        try {
            authenticationRepository.addUserWithRole(newUser.getName(), newUser.getEmail(), newUser.getPassword(), AuthenticationController.ROLE_CLIENT);
        } catch (Exception e){
            System.out.println("Couldn't register user with authetication system. " + e.getMessage());
        }
        //if (success2) System.out.println("succ");
        return success;
    }
}
