package app.domain.model;

import java.util.ArrayList;

public class Land extends Property{

    public Land(float area, City address, float cityCentreDistance, ArrayList<String> photographs) {
        super(area, address, cityCentreDistance, photographs);
    }
}
