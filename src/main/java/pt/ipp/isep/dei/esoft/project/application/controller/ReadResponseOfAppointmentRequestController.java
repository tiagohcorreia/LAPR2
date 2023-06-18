package pt.ipp.isep.dei.esoft.project.application.controller;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.repository.ScheduleRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReadResponseOfAppointmentRequestController implements Initializable {

    ScheduleRepository scheduleRepository = Repositories.getInstance().getScheduleRepository();

    Schedule currentSchedule;

    @FXML
    private Button btnAccept;

    @FXML
    private TextField txtSchedule;

    @FXML
    private TextField txtClientReason;

    @FXML
    private ListView<Schedule> lstSchedules;

    @FXML
    private Button btnReject;

    @FXML
    private Button btnClear;

    @FXML
    void acceptRequest(ActionEvent event) {

        currentSchedule.setClientApproval(true);
        scheduleRepository.saveSchedule(currentSchedule);
        scheduleRepository.writeObjectScheduleRequest();
    }

    @FXML
    void rejectRequest(ActionEvent event) {

        txtClientReason.setText("Insert the reason here");
        currentSchedule.setNoteFromClient(txtClientReason.getText());
        scheduleRepository.saveSchedule(currentSchedule);
        scheduleRepository.writeObjectScheduleRequest();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        sendNotificationToAgent();
        lstSchedules.getItems().addAll(getScheduleList());
        lstSchedules.getSelectionModel().selectedItemProperty().addListener(this::selectionChanged);
    }

    @FXML
    void clear(ActionEvent event) {

        txtClientReason.clear();
        txtSchedule.clear();
    }

    public void sendNotificationToAgent() {

        String conteudo = "A client have just view the response for a schedule";

        try {

            FileWriter file = new FileWriter(new File("APP_FILES/Agent_Notification.txt"), true);
            file.write(conteudo + "\n");
            file.close();

        } catch (IOException e) {

            System.out.println("Error creating file");
            e.printStackTrace();
        }

    }

    public List<Schedule> getScheduleList() {

        return scheduleRepository.readObjectScheduleRequest();
    }

    private void selectionChanged(ObservableValue< ? extends Schedule> observable, Schedule oldVal, Schedule newVal) {

        currentSchedule = lstSchedules.getSelectionModel().getSelectedItem();
        txtSchedule.setText(currentSchedule.getNoteFromAgent());
    }

}
