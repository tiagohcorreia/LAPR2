package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public enum Role {

    ADMNISTRATOR, MANAGER, AGENT;

    public static String asString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0").append(ADMNISTRATOR.toString()).append("\n");
        stringBuilder.append("1").append(MANAGER.toString()).append("\n");
        stringBuilder.append("2").append(AGENT.toString()).append("\n");

        return stringBuilder.toString();
    }

    public static List<Role> getRolesAsList() {

        List<Role> roles = new ArrayList<>();

        roles.add(ADMNISTRATOR);  //0
        roles.add(MANAGER);      //1
        roles.add(AGENT);       //2

        return roles;
    }

    public static Role getRoleByID(int position) {

        List<Role> aux = getRolesAsList();

        return aux.get(position);
    }


}
