package pt.ipp.isep.dei.esoft.project.application.controller;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.repository.ScheduleRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * The type Read response of appointment request controller.
 */
public class ReadResponseOfAppointmentRequestController implements Initializable {

    /**
     * The Schedule repository.
     */
    ScheduleRepository scheduleRepository = Repositories.getInstance().getScheduleRepository();

    /**
     * The Current schedule.
     */
    Schedule currentSchedule = new Schedule();

    @FXML
    private Button btnAccept;

    @FXML
    private TextField txtSchedule;

    @FXML
    private ListView<Schedule> lstSchedules;

    @FXML
    private Button btnReject;

    @FXML
    private Button btnClear;

    /**
     * Accept request.
     *
     * @param event the event
     */
    @FXML
    void acceptRequest(ActionEvent event) {

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);

        confirmation.setTitle("CONFIRMATION");
        confirmation.setHeaderText("Accept Appointment Request");
        confirmation.setContentText("Are you sure you want to accept this request?");

        confirmation.showAndWait().ifPresent(reponse -> {

            if (reponse == ButtonType.OK) {

                currentSchedule.setClientApproval(true);
                scheduleRepository.saveSchedule(currentSchedule);
                scheduleRepository.writeObjectScheduleRequest();
                closeProgram();
            }
        });
    }

    /**
     * Reject request.
     *
     * @param event the event
     */
    @FXML
    void rejectRequest(ActionEvent event) {

        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle("Reason");
        dialog.setHeaderText("Enter the reason for rejection:");
        dialog.setContentText("Reason:");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {

            String reason = result.get();

            currentSchedule.setNoteFromClient(reason);
            scheduleRepository.saveSchedule(currentSchedule);
            scheduleRepository.writeObjectScheduleRequest();
            closeProgram();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        sendNotificationToAgent();
        lstSchedules.getItems().addAll(getScheduleList());
        lstSchedules.getSelectionModel().selectedItemProperty().addListener(this::selectionChanged);
    }

    /**
     * Clear.
     *
     * @param event the event
     */
    @FXML
    void clear(ActionEvent event) {
        txtSchedule.clear();
    }

    /**
     * Gets schedule list.
     *
     * @return the schedule list
     */
    public List<Schedule> getScheduleList() {

        return scheduleRepository.readObjectScheduleRequest();
    }

    private void selectionChanged(ObservableValue<? extends Schedule> observable, Schedule oldVal, Schedule newVal) {

        currentSchedule = lstSchedules.getSelectionModel().getSelectedItem();
        txtSchedule.setText(currentSchedule.getNoteFromAgent());
    }

    private void closeProgram() {

        Stage stage = (Stage) btnAccept.getScene().getWindow();
        stage.close();
    }

    /**
     * Send notification to agent.
     */
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
}
