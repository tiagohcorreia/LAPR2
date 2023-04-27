package app.domain.model;

import java.util.ArrayList;

public class Land extends Property{

    public Land(float area, City location, float cityCentreDistance, ArrayList<String> photographs) {
        super(area, location, cityCentreDistance, photographs);
    }

    @Override
    public String toString() {
        return "Land{"+super.toString()+
                "}";
    }
}
