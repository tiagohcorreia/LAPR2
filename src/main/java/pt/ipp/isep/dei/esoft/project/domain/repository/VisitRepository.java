package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;
import pt.ipp.isep.dei.esoft.project.domain.model.Visit;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class VisitRepository {

    public static List<Visit> VisitList = new ArrayList<>();
    public static List<Visit> VisitByAgent= new ArrayList<>();



    public boolean saveVisit(Visit visit){
        if(validateVisit(visit)) {
            return addVisit(visit);
        }
        return false;
    }
    public boolean validateVisit(Visit visit){
        for(Visit visit1: VisitList) {

            if(visit.equals(visit1)) {
                return false;
            }
        }
        return true;
    }

    public boolean addVisit(Visit visit){
        if(visit != null && validateVisit(visit)) {

            return this.VisitList.add(visit);
        }
        return false;
    }

}
