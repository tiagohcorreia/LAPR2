package pt.ipp.isep.dei.esoft.project.domain.repository;

//import pt.isep.lei.esoft.auth.domain.model.User;
import com.sun.jdi.request.DuplicateRequestException;
import pt.ipp.isep.dei.esoft.project.domain.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private List<Client> clients = new ArrayList<>();

    public boolean add(Client client){
        if (userExists(client))
            throw new DuplicateRequestException("This user is already registered");
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


}
