package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.repository.PlaceOrderToBuyPropertyRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.ScheduleRepository;

public class ScheduleVisitController {

    private ScheduleRepository scheduleRepository;

    public ScheduleVisitController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;

    }

}
