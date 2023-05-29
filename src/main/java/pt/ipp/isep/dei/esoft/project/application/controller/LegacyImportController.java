package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.ClientRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.exceptions.InvalidFileTypeException;
import pt.ipp.isep.dei.esoft.project.utils.CsvHandler;
import pt.ipp.isep.dei.esoft.project.utils.FileOps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class LegacyImportController {
    private static final String LEGACY_AGENT_NAME = "Legacy Agent";
    //private static final String LEGACY_AGENT_PASSPORT_NUMBER = "000000000";
    private static final int LEGACY_AGENT_PASSPORT_NUMBER = 0;
    //private static final String LEGACY_AGENT_TAX_NUMBER = "000000000";
    private static final int LEGACY_AGENT_TAX_NUMBER = 0;
    private static final String LEGACY_AGENT_EMAIL = "legacy@realstateUSA.com";
    //private static final String LEGACY_AGENT_PHONE_NUMBER = "0000000000";
    private static final int LEGACY_AGENT_PHONE_NUMBER = 0;

    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
    EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
    ClientRepository clientRepository = Repositories.getInstance().getClientRepository();


    public void importFile(String filePath) throws InvalidFileTypeException {
        File f = null;
        try {
            f = FileOps.readFile(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        List<?> csv = CsvHandler.getDataFromCsvFile(f);

        /*
        if (csv.size() < 2){
            throw new RuntimeException("File is empty");
        }
         */

        Employee legacyEmployee = employeeRepository.getEmployee("Legacy Agent");
        if (legacyEmployee == null){
            legacyEmployee = employeeRepository.createEmployee(
                    LEGACY_AGENT_NAME,
                    LEGACY_AGENT_PASSPORT_NUMBER,
                    LEGACY_AGENT_TAX_NUMBER,
                    "",
                    LEGACY_AGENT_EMAIL,
                    LEGACY_AGENT_PHONE_NUMBER,
                    null,
                    null
            );
            employeeRepository.saveEmployee(legacyEmployee);
        }

        CsvHandler.parseCSV(csv);

    }
}
