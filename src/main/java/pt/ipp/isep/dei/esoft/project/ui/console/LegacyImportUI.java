package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.LegacyImportController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

public class LegacyImportUI implements Runnable{
    LegacyImportController controller = new LegacyImportController();
    @Override
    public void run() {
        System.out.println("IMPORT LEGACY DATA");
        String filePath = getFilePath();


    }

    private String getFilePath(){
        String filePath = new String();
        while (filePath.equals("")){
                filePath = Utils.readLineFromConsole("File path: ").trim();
                if (filePath.equals(""))
                    System.out.println("File path cannot be empty. Please try again");
        }
        return filePath;
    }
}
