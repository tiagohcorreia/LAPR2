package pt.ipp.isep.dei.esoft.project.domain.repository;

//import pt.isep.lei.esoft.auth.domain.model.User;
import com.sun.jdi.request.DuplicateRequestException;
import pt.ipp.isep.dei.esoft.project.domain.model.Client;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.exceptions.DuplicateDataException;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Client repository.
 */
public class ClientRepository {
    private List<Client> clients = new ArrayList<>();

    /**
     * Create client client.
     *
     * @param name            the name
     * @param email           the email
     * @param cCNumber        the c c number
     * @param taxNumber       the tax number
     * @param telephoneNumber the telephone number
     * @return the client
     */
    public Client createClient(String name, String email, int cCNumber, int taxNumber, long telephoneNumber){
        return new Client(name, email, cCNumber, taxNumber, telephoneNumber);
    }

    /**
     * Add boolean.
     *
     * @param client the client
     * @return the boolean
     */
    public boolean add(Client client){
        if (userExists(client))
            throw new DuplicateDataException("This user is already registered");
        else
            return clients.add(client);

    }

    /**
     * User exists boolean.
     *
     * @param client the client
     * @return the boolean
     */
    public boolean userExists(Client client){
        for (Client repoClient : clients) {
            if (client.equals(repoClient))
                return true;
        }
        return false;
    }

    /**
     * Get users list.
     *
     * @return the list
     */
    public List<Client> getUsers(){
        List<Client> clientList = new ArrayList<>();
        clientList.addAll(clients);
        return clientList;
    }

    /**
     * Find by email client.
     *
     * @param email the email
     * @return the client
     */
    public Client findByEmail(String email) {
        for (Client client : clients) {
            if (client.getEmail().equals(email)) {
                return client;
            }
        }
        return null;
    }

    /**
     * Find by name client.
     *
     * @param name the name
     * @return the client
     */
    public Client findByName(String name) {
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }

}
