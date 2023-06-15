package pt.ipp.isep.dei.esoft.project.application.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.w3c.dom.Text;

import java.awt.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.repository.ScheduleRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.menu.MainMenuUI;


public class ReadResponseOfAppointmentRequestController implements Initializable {

    ScheduleRepository scheduleRepository = Repositories.getInstance().getScheduleRepository();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        getScheduleList();
    }


    @FXML
    private Button btnAccept;

    @FXML
    private Button btnCancel;

    @FXML
    private ListView<Schedule> lstSchedule;

    @FXML
    private Text txtScheduleMessage;

    @FXML
    private Button btnReject;

    @FXML
    void acceptRequest(ActionEvent event) {

        /*for(Schedule lstSchedule) {

        }*/
    }

    @FXML
    void rejectRequest(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {
        new MainMenuUI();
    }

    public List<Schedule> getScheduleList() {

        List<Schedule> lstSchedule = scheduleRepository.readObjectScheduleRequest();

        return lstSchedule;
    }


}
