package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ListAllEmployeesController;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class ListAllEmplyeesUI implements Runnable {

    private ListAllEmployeesController controller = new ListAllEmployeesController();

    @Override
    public void run() {

        //Get Employee List
        List<Employee> x = this.controller.getAllEmployees();
        Utils.showList(x, " === Employee List ===");
    }
}
