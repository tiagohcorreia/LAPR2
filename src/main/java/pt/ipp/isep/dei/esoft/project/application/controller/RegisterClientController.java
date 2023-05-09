package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.model.Client;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.repository.ClientRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
//import pt.isep.lei.esoft.auth.AuthFacade;

import java.util.List;

public class RegisterClientController {
    private AuthenticationRepository authenticationRepository = pt.ipp.isep.dei.esoft.project.repository.Repositories.getInstance().getAuthenticationRepository();
    private ClientRepository clientRepository = Repositories.getInstance().getUserRepository();
    //private AuthFacade authFacade = new AuthFacade();

    public Client createUser(List<String> input) {
        Client newClient = null;
        try {
            newClient = new Client(input);
        } catch (Exception e){
            System.out.println("Couldn't create user. " + e.getMessage());
        }
        return newClient;
    }

    public boolean addUser(Client newClient){
        boolean success = false;
        try {
             success = clientRepository.add(newClient);
        } catch (Exception e) {
            System.out.println("Couldn't save user: " + e.getMessage());
        }
        //authFacade.addUserWithRole(newUser.getName(), newUser.getEmail(), newUser.getPassword(), AuthenticationController.ROLE_CLIENT);
        try {
            authenticationRepository.addUserWithRole(newClient.getName(), newClient.getEmail(), newClient.getPassword(), AuthenticationController.ROLE_CLIENT);
        } catch (Exception e){
            System.out.println("Couldn't register user with authetication system. " + e.getMessage());
        }
        //if (success2) System.out.println("succ");
        return success;
    }
}
