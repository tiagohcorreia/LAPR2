package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.LegacyImportController;
import pt.ipp.isep.dei.esoft.project.exceptions.InvalidFileTypeException;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.FileNotFoundException;


public class LegacyImportUI implements Runnable{
    LegacyImportController controller = new LegacyImportController();
    @Override
    public void run() {
        System.out.println("IMPORT LEGACY DATA");
        String filePath = getFilePath();

        try {
            controller.importFile(filePath);
        } catch (InvalidFileTypeException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }

    private String getFilePath(){
        String filePath = "";
        while (filePath.equals("")){
                filePath = Utils.readLineFromConsole("File path: ").trim();
                if (filePath.equals("")){
                    System.out.println("File path cannot be empty. Please try again");
                    Utils.readLineFromConsole("Press [Enter] to continue...");
                }
        }
        return filePath;
    }
}
