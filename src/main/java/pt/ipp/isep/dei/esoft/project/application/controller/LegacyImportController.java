package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.ClientRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;

public class LegacyImportController {
    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
    EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
    ClientRepository clientRepository = Repositories.getInstance().getClientRepository();


}
