package pt.ipp.isep.dei.esoft.project.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.shared.Rating;

import java.time.LocalDate;
import java.time.LocalTime;

public class VisitTest {
    private Visit visit;

    @BeforeEach
    public void setup() {
        LocalDate day = LocalDate.of(2023, 5, 1);
        LocalTime beginHour = LocalTime.of(10, 0);
        LocalTime endHour = LocalTime.of(11, 0);
        Schedule scheduleVisit = new Schedule("John Doe", 1234567890, null, day, beginHour, endHour, "Note", true, true);
        String opinionAboutBusiness = "Great experience!";
        Rating rating = Rating.VERY_ABOVE_EXPECTATIONS;

        visit = new Visit(scheduleVisit, opinionAboutBusiness, rating);
    }

    @Test
    public void ensureGetScheduleVisitReturnsCorrectValue() {
        LocalDate expectedDay = LocalDate.of(2023, 5, 1);
        LocalTime expectedBeginHour = LocalTime.of(10, 0);
        LocalTime expectedEndHour = LocalTime.of(11, 0);
        Schedule expected = new Schedule("John Doe", 1234567890, null, expectedDay, expectedBeginHour, expectedEndHour, "Note", true, true);

        Schedule actual = visit.getScheduleVisit();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ensureGetOpinionAboutBusinessReturnsCorrectValue() {
        String expected = "Great experience!";
        String actual = visit.getOpinionAboutBusiness();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ensureSetOpinionAboutBusinessTruncatesLongOpinions() {
        String longOpinion = "This is a very long opinion about the business. It should be truncated to 200 characters.";
        String expected = "This is a very long opinion about the business. It should be truncated to 200 characters.";

        visit.setOpinionAboutBusiness(longOpinion);
        String actual = visit.getOpinionAboutBusiness();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ensureSetOpinionAboutBusinessDoesNotTruncateShortOpinions() {
        String shortOpinion = "Short opinion.";
        String expected = "Short opinion.";

        visit.setOpinionAboutBusiness(shortOpinion);
        String actual = visit.getOpinionAboutBusiness();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ensureGetRatingReturnsCorrectValue() {
        Rating expected = Rating.VERY_ABOVE_EXPECTATIONS;
        Rating actual = visit.getRating();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ensureEqualsReturnsTrueForSameObject() {
        boolean result = visit.equals(visit);

        Assertions.assertTrue(result);
    }

    @Test
    public void ensureEqualsReturnsTrueForEqualVisits() {
        LocalDate day = LocalDate.of(2023, 5, 1);
        LocalTime beginHour = LocalTime.of(10, 0);
        LocalTime endHour = LocalTime.of(11, 0);
        Schedule scheduleVisit = new Schedule("John Doe", 1234567890, null, day, beginHour, endHour, "Note", true, true);
        String opinionAboutBusiness = "Great experience!";
        Rating rating = Rating.VERY_ABOVE_EXPECTATIONS;

        Visit visit2 = new Visit(scheduleVisit, opinionAboutBusiness, rating);

        boolean result = visit.equals(visit2);

        Assertions.assertTrue(result);
    }

    @Test
    public void ensureEqualsReturnsFalseForDifferentClass() {
        Object obj = new Object();

        boolean result = visit.equals(obj);

        Assertions.assertFalse(result);
    }

    @Test
    public void ensureEqualsReturnsFalseForNull() {
        boolean result = visit.equals(null);

        Assertions.assertFalse(result);
    }

    @Test
    public void ensureEqualsReturnsFalseForDifferentScheduleVisit() {
        LocalDate day = LocalDate.of(2023, 5, 2);
        LocalTime beginHour = LocalTime.of(14, 0);
        LocalTime endHour = LocalTime.of(15, 0);
        Schedule scheduleVisit = new Schedule("Jane Smith", 987654321, null, day, beginHour, endHour, "Note", true, true);
        String opinionAboutBusiness = "Great experience!";
        Rating rating = Rating.VERY_ABOVE_EXPECTATIONS;

        Visit visit2 = new Visit(scheduleVisit, opinionAboutBusiness, rating);

        boolean result = visit.equals(visit2);

        Assertions.assertFalse(result);
    }
}
