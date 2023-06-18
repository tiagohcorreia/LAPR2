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

/**
 * The type Legacy import controller.
 */
public class LegacyImportController {
    private static final String LEGACY_AGENT_NAME = "Legacy Agent";
    //private static final String LEGACY_AGENT_PASSPORT_NUMBER = "000000000";
    private static final int LEGACY_AGENT_PASSPORT_NUMBER = 100000000;
    //private static final String LEGACY_AGENT_TAX_NUMBER = "000000000";
    private static final int LEGACY_AGENT_TAX_NUMBER = 100000000;
    private static final String LEGACY_AGENT_EMAIL = "legacy@realstateUSA.com";
    private static final String LEGACY_AGENT_ADDRESS = "Legacy Employee Address";
    //private static final String LEGACY_AGENT_PHONE_NUMBER = "0000000000";
    private static final int LEGACY_AGENT_PHONE_NUMBER = 1000000000;

    /**
     * The Announcement repository.
     */
    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
    /**
     * The Employee repository.
     */
    EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
    /**
     * The Client repository.
     */
    ClientRepository clientRepository = Repositories.getInstance().getClientRepository();


    /**
     * Import file int.
     *
     * @param filePath the file path
     * @return the int
     * @throws InvalidFileTypeException the invalid file type exception
     * @throws FileNotFoundException    the file not found exception
     */
    public int importFile(String filePath) throws InvalidFileTypeException, FileNotFoundException {
        int failedImports = 0;
        File csvFile = null;
        csvFile = FileOps.readFile(filePath);
        List<?> csv = CsvHandler.getDataFromCsvFile(csvFile);

        Employee legacyEmployee = employeeRepository.getEmployee("Legacy Agent");
        if (legacyEmployee == null){
            legacyEmployee = employeeRepository.createEmployee(
                    LEGACY_AGENT_NAME,
                    LEGACY_AGENT_PASSPORT_NUMBER,
                    LEGACY_AGENT_TAX_NUMBER,
                    LEGACY_AGENT_ADDRESS,
                    LEGACY_AGENT_EMAIL,
                    String.valueOf(LEGACY_AGENT_PHONE_NUMBER),
                    null,
                    null
            );
            employeeRepository.saveEmployee(legacyEmployee);
        }

        return CsvHandler.parseCSV(csv);

    }
}
