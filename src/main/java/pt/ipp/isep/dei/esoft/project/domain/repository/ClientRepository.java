package pt.ipp.isep.dei.esoft.project.domain.repository;

//import pt.isep.lei.esoft.auth.domain.model.User;
import com.sun.jdi.request.DuplicateRequestException;
import pt.ipp.isep.dei.esoft.project.domain.model.Client;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.exceptions.DuplicateDataException;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private List<Client> clients = new ArrayList<>();

    public Client createClient(String name, String email, int cCNumber, int taxNumber, long telephoneNumber){
        return new Client(name, email, cCNumber, taxNumber, telephoneNumber);
    }

    public boolean add(Client client){
        if (userExists(client))
            throw new DuplicateDataException("This user is already registered");
        else
            return clients.add(client);

    }

    public boolean userExists(Client client){
        for (Client repoClient : clients) {
            if (client.equals(repoClient))
                return true;
        }
        return false;
    }

    public List<Client> getUsers(){
        List<Client> clientList = new ArrayList<>();
        clientList.addAll(clients);
        return clientList;
    }

    public Client findByEmail(String email) {
        for (Client client : clients) {
            if (client.getEmail().equals(email)) {
                return client;
            }
        }
        return null;
    }
    public Client findByName(String name) {
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }

}
