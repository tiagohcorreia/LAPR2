package pt.ipp.isep.dei.esoft.project.domain.model;

import pt.ipp.isep.dei.esoft.project.domain.shared.Rating;

import java.util.Objects;

public class Visit {

    private Schedule scheduleVisit;
    private String opinionAboutBusiness;
    private Rating rating;


    public Visit( Schedule scheduleVisit, String opinionAboutBusiness, Rating rating){
        this.scheduleVisit = scheduleVisit;
        this.opinionAboutBusiness = opinionAboutBusiness;
        this.rating = rating;
    }





    public Schedule getScheduleVisit() {
        return scheduleVisit;
    }

    public void setScheduleVisit(Schedule scheduleVisit) {
        this.scheduleVisit = scheduleVisit;
    }

    public String getOpinionAboutBusiness() {
        return opinionAboutBusiness;
    }

    public void setOpinionAboutBusiness(String opinionAboutBusiness) {
        if(opinionAboutBusiness.length() > 200){
            this.opinionAboutBusiness = opinionAboutBusiness.substring(0, 200);
        } else {
            this.opinionAboutBusiness = opinionAboutBusiness;
        }
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Visit other = (Visit) obj;
        return Objects.equals(scheduleVisit, other.scheduleVisit)
                && Objects.equals(opinionAboutBusiness, other.opinionAboutBusiness)
                && rating == other.rating;
    }

    @Override
    public String toString() {
        return "Visit:" +
                scheduleVisit +
                opinionAboutBusiness +
                "rating - " + rating
                ;
    }
}
