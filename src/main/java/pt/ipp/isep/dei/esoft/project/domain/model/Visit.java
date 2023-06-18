package pt.ipp.isep.dei.esoft.project.domain.model;

import pt.ipp.isep.dei.esoft.project.domain.shared.Rating;

import java.util.Objects;

/**
 * The type Visit.
 */
public class Visit {

    private Schedule scheduleVisit;
    private String opinionAboutBusiness;
    private Rating rating;


    /**
     * Instantiates a new Visit.
     *
     * @param scheduleVisit        the schedule visit
     * @param opinionAboutBusiness the opinion about business
     * @param rating               the rating
     */
    public Visit( Schedule scheduleVisit, String opinionAboutBusiness, Rating rating){
        this.scheduleVisit = scheduleVisit;
        this.opinionAboutBusiness = opinionAboutBusiness;
        this.rating = rating;
    }


    /**
     * Gets schedule visit.
     *
     * @return the schedule visit
     */
    public Schedule getScheduleVisit() {
        return scheduleVisit;
    }

    /**
     * Sets schedule visit.
     *
     * @param scheduleVisit the schedule visit
     */
    public void setScheduleVisit(Schedule scheduleVisit) {
        this.scheduleVisit = scheduleVisit;
    }

    /**
     * Gets opinion about business.
     *
     * @return the opinion about business
     */
    public String getOpinionAboutBusiness() {
        return opinionAboutBusiness;
    }

    /**
     * Sets opinion about business.
     *
     * @param opinionAboutBusiness the opinion about business
     */
    public void setOpinionAboutBusiness(String opinionAboutBusiness) {
        if(opinionAboutBusiness.length() > 200){
            this.opinionAboutBusiness = opinionAboutBusiness.substring(0, 200);
        } else {
            this.opinionAboutBusiness = opinionAboutBusiness;
        }
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public Rating getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
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
