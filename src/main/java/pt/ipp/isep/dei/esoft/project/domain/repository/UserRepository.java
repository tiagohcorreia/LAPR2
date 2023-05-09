package pt.ipp.isep.dei.esoft.project.domain.repository;

//import pt.isep.lei.esoft.auth.domain.model.User;
import com.sun.jdi.request.DuplicateRequestException;
import pt.ipp.isep.dei.esoft.project.domain.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public boolean add(User user){
        if (userExists(user))
            throw new DuplicateRequestException("This user is already registered");
        else
            return users.add(user);

    }

    public boolean userExists(User user){
        for (User repoUser : users) {
            if (user.equals(repoUser))
                return true;
        }
        return false;
    }

    public List<User> getUsers(){
        List<User> userList = new ArrayList<>();
        for (User user:
             users) {
            userList.add(user);
        }
        return userList;
    }


}
