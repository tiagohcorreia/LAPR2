package app.controller;

import app.domain.model.Agency;
import app.domain.model.City;
import app.domain.model.Employee;
import app.domain.model.Role;
import app.domain.repository.AnnouncementRepository;
import app.domain.repository.CityRepository;
import app.domain.repository.RegisterEmployeeRepository;
import app.domain.repository.Repositories;
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