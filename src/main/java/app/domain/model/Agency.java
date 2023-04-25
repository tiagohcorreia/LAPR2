package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public enum Agency {

    AGENCY1, AGENCY2, AGENCY3;

    public static String asString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0").append(AGENCY1.toString()).append("\n");
        stringBuilder.append("1").append(AGENCY2.toString()).append("\n");
        stringBuilder.append("2").append(AGENCY3.toString()).append("\n");

        return stringBuilder.toString();
    }

    public static List<Agency> getAgencyAsList() {

        List<Agency> agency = new ArrayList<>();

        agency.add(AGENCY1); //0
        agency.add(AGENCY2); //1
        agency.add(AGENCY3); //2

        return agency;
    }

    public static Agency getRolebyID(int position) {

        List<Agency> aux = getAgencyAsList();

        return aux.get(position);
    }

}
