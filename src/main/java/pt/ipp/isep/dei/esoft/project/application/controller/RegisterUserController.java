package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.model.User;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.repository.UserRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;

import javax.management.InvalidAttributeValueException;
import java.util.List;

public class RegisterUserController {
    private AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
    private UserRepository userRepository = Repositories.getInstance().getUserRepository();

    public User createUser(List<String> input) {
        return new User(input);
    }

    public boolean addUser(User newUser){
        boolean success = false;
        try {
             success = userRepository.add(newUser);
        } catch (Exception e) {
            System.out.println("Couldn't save user: " + e.getMessage());
        }
        authenticationRepository.addUserWithRole(newUser.getName(), newUser.getEmail(), newUser.getPassword(), AuthenticationController.ROLE_CLIENT);
        return success;
    }
}
