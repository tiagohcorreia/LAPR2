package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.Agency;
import pt.ipp.isep.dei.esoft.project.domain.model.City;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.model.Role;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.CityRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.RegisterEmployeeRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RegisterPropertyControllerTest {
    private AnnouncementRepository announcementRepository;
    Repositories repositories = Repositories.getInstance();
    RegisterEmployeeRepository employeeRepository = repositories.getEmployeeRepository();
    CityRepository cityRepository=repositories.getCityRepository();
    @Test
    void createAnnouncement() {

    }

    @Test
    void getEmployee() {
    }

    @Test
    void getCity() {
    }

    @Test
    void getSunExposureAsList() {
    }

    @Test
    void getTypeOfPropertyAsList() {
    }

    @Test
    void getTypeOfBusinessAsList() {
    }

    @Test
    void testCreateAnnouncement() {
    }

    @Test
    void testGetAgent() {
    }

    @Test
    void testGetEmployee() {
    }

    @Test
    void testGetCity() {
    }

    @Test
    void testGetSunExposureAsList() {
    }

    @Test
    void testGetTypeOfPropertyAsList() {
    }

    @Test
    void testGetTypeOfBusinessAsList() {
    }
}