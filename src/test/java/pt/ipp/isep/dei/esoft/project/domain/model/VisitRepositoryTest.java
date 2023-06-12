package pt.ipp.isep.dei.esoft.project.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.repository.VisitRepository;
import pt.ipp.isep.dei.esoft.project.domain.shared.Rating;

import java.time.LocalDate;
import java.time.LocalTime;

public class VisitRepositoryTest {

    private VisitRepository visitRepository;
    private Visit visit;

    @BeforeEach
    public void setup() {
        visitRepository = new VisitRepository();

        LocalDate day = LocalDate.of(2023, 5, 2);
        LocalTime beginHour = LocalTime.of(14, 0);
        LocalTime endHour = LocalTime.of(15, 0);
        Schedule scheduleVisit = new Schedule("John Smith", 1234567890, null, day, beginHour, endHour, "Note", true, true);
        String opinionAboutBusiness = "Great experience!";
        Rating rating = Rating.VERY_ABOVE_EXPECTATIONS;

        visit = new Visit(scheduleVisit, opinionAboutBusiness, rating);
    }

    @Test
    public void ensureSaveVisitReturnsTrueWhenVisitIsValidAndNotDuplicate() {
        boolean result = visitRepository.saveVisit(visit);

        Assertions.assertTrue(result);
    }

    @Test
    public void ensureSaveVisitReturnsFalseWhenVisitIsNull() {
        boolean result = visitRepository.saveVisit(null);

        Assertions.assertFalse(result);
    }

    @Test
    public void ensureSaveVisitReturnsFalseWhenVisitIsDuplicate() {
        visitRepository.saveVisit(visit);

        boolean result = visitRepository.saveVisit(visit);

        Assertions.assertFalse(result);
    }
}