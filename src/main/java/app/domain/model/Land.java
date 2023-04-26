package app.domain.model;

import java.util.ArrayList;

public class Land extends Property{

    public Land(int propertyID, float area, City address, float cityCentreDistance, ArrayList<String> photographs) {
        super(propertyID, area, address, cityCentreDistance, photographs);
    }
}
