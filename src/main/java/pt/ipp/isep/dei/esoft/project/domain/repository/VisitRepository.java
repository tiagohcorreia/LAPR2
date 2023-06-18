package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;
import pt.ipp.isep.dei.esoft.project.domain.model.Visit;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


/**
 * The type Visit repository.
 */
public class VisitRepository {

    /**
     * The constant VisitList.
     */
    public static List<Visit> VisitList = new ArrayList<>();
    /**
     * The constant VisitByAgent.
     */
    public static List<Visit> VisitByAgent= new ArrayList<>();


    /**
     * Save visit boolean.
     *
     * @param visit the visit
     * @return the boolean
     */
    public boolean saveVisit(Visit visit){
        if(validateVisit(visit)) {
            return addVisit(visit);
        }
        return false;
    }

    /**
     * Validate visit boolean.
     *
     * @param visit the visit
     * @return the boolean
     */
    public boolean validateVisit(Visit visit){
        for(Visit visit1: VisitList) {

            if(visit.equals(visit1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Add visit boolean.
     *
     * @param visit the visit
     * @return the boolean
     */
    public boolean addVisit(Visit visit){
        if(visit != null && validateVisit(visit)) {

            return this.VisitList.add(visit);
        }
        return false;
    }

}
