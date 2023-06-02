package pt.ipp.isep.dei.esoft.project.domain.model;

import java.util.ArrayList;

/**
 * The type Land.
 */
public class Land extends Property{

    /**
     * Instantiates a new Land.
     *
     * @param area               the area
     * @param location           the location
     * @param cityCentreDistance the city centre distance
     * @param photographs        the photographs
     */
    public Land(float area, Location location, float cityCentreDistance, ArrayList<String> photographs) {
        super(area, location, cityCentreDistance, photographs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Land \n");
        sb.append(super.toString());
        return sb.toString();
    }
}
