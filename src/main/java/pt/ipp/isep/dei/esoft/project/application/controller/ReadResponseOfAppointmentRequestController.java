package pt.ipp.isep.dei.esoft.project.application.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.w3c.dom.Text;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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


    @FXML
    private Button btnAccept;

    @FXML
    private Button btnCancel;

    @FXML
    private ListView<Schedule> lstSchedule;

    @FXML
    private Text txtScheduleMessage;

    @FXML
    private Text txtReason;

    @FXML
    private Button btnReject;

    @FXML
    void acceptRequest(ActionEvent event) {

    }

    @FXML
    void rejectRequest(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {
        new MainMenuUI();
    }

    public List<Schedule> getScheduleList() {

        return scheduleRepository.readObjectScheduleRequest();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lstSchedule = (ListView<Schedule>) getScheduleList();
        sendNotificationToAgent();
    }

    public void sendNotificationToAgent() {

        String conteudo = "A client just have just view the response for the schedule";

        try {

            FileWriter file = new FileWriter(new File("APP_FILES/Agent_Notification.txt"), true);
            file.write(conteudo + "\n");
            file.close();
            System.out.println("Notification to agent was send with success");

        } catch (IOException e) {

            System.out.println("Error creating file");
            e.printStackTrace();
        }

    }


}
