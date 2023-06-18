package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.LegacyImportController;
import pt.ipp.isep.dei.esoft.project.exceptions.InvalidFileTypeException;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.FileNotFoundException;


/**
 * The type Legacy import ui.
 */
public class LegacyImportUI implements Runnable{
    /**
     * The Controller.
     */
    LegacyImportController controller = new LegacyImportController();
    @Override
    public void run() {
        System.out.println("IMPORT LEGACY DATA");
        String filePath = getFilePath();

        try {
            System.out.println("Imported "+ controller.importFile(filePath) + " announcements.");
        } catch (InvalidFileTypeException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Utils.enterToContinue();
    }

    private String getFilePath(){
        String filePath = "";
        while (filePath.equals("")){
                filePath = Utils.readLineFromConsole("File path: ").trim();
                if (filePath.equals("")){
                    System.out.println("File path cannot be empty. Please try again");
                    Utils.enterToContinue();
                }
        }
        return filePath;
    }
}
