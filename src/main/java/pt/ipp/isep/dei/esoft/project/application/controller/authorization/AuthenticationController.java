package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.application.session.UserSession;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;
import pt.isep.lei.esoft.auth.AuthFacade;


import java.util.List;

/**
 * The type Authentication controller.
 */
public class AuthenticationController {

    /**
     * The constant ROLE_ADMIN.
     */
    public static final String ROLE_ADMIN = "ADMINISTRATOR";
    /**
     * The constant ROLE_EMPLOYEE.
     */
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";
    /**
     * The constant ROLE_OWNER.
     */
    public static final String ROLE_OWNER = "OWNER";
    public static final String ROLE_NETWORK_MANAGER = "NETWORK_MANAGER";
    public static final String ROLE_UNREGISTERED = "UNREGISTERED_USER";
    public static final String ROLE_STORE_MANAGER = "STORE_MANAGER";
    public static final String ROLE_CLIENT = "CLIENT";
    public static final String ROLE_AGENT = "AGENT";

    //private final ApplicationSession applicationSession;
    private final AuthenticationRepository authenticationRepository;

    /**
     * Instantiates a new Authentication controller.
     */
    public AuthenticationController() {
        this.authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
    }

    /**
     * Do login boolean.
     *
     * @param email the email
     * @param pwd   the pwd
     * @return the boolean
     */
    public boolean doLogin(String email, String pwd) {
        try {
            return authenticationRepository.doLogin(email, pwd);
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    /**
     * Gets user roles.
     *
     * @return the user roles
     */
    public List<UserRoleDTO> getUserRoles() {
        if (authenticationRepository.getCurrentUserSession().isLoggedIn()) {
            return authenticationRepository.getCurrentUserSession().getUserRoles();
        }
        return null;
    }

    /**
     * Do logout.
     */
    public void doLogout() {
        authenticationRepository.doLogout();
    }


    /**
     * Get current session pt . ipp . isep . dei . esoft . project . application . session . user session.
     *
     * @return the pt . ipp . isep . dei . esoft . project . application . session . user session
     */
    public pt.ipp.isep.dei.esoft.project.application.session.UserSession getCurrentSession(){
        pt.isep.lei.esoft.auth.UserSession userSession = this.authenticationRepository.getCurrentUserSession();
        return new pt.ipp.isep.dei.esoft.project.application.session.UserSession(userSession);
    }
    public String getAgentName() {
       pt.isep.lei.esoft.auth.UserSession userSession = authenticationRepository.getCurrentUserSession();
        if (userSession != null) {
            userSession.getUserName();
            return userSession.getUserName();
        } else {
            return null;
        }
    }

   public String getCurrentUserSession() {
       pt.isep.lei.esoft.auth.UserSession userSession = this.authenticationRepository.getCurrentUserSession();
        return userSession.getUserName();
   }

}
