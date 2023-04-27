package app.controller.session;

import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

import java.util.List;

public class UserSession {

    private UserSession userSession;

    public UserSession(UserSession userSession) {
        this.userSession = userSession;
    }

   /* public String getUserEmail(){
        return userSession.getUserId().getEmail();
    }*/

    public String getUserEmail() {
        return userSession.getUserEmail();
    }

    public String getUserName(){
        return this.userSession.getUserName();
    }

    public List<UserRoleDTO> getUserRoles(){
        return this.userSession.getUserRoles();
    }

    public void doLogout() {
        this.userSession.doLogout();
    }

    public boolean isLoggedIn() {
        return this.userSession.isLoggedIn();
    }

    public boolean isLoggedInWithRole(String roleId) {
        return this.userSession.isLoggedInWithRole(roleId);
    }

}
