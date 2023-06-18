package pt.ipp.isep.dei.esoft.project.application.controller;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.repository.ScheduleRepository;

import java.net.URL;
import java.util.ResourceBundle;

import pt.ipp.isep.dei.esoft.project.domain.model.Location;
import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;



import java.io.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Properties;


/**
 * The type Validate schedule controller.
 */
public class ValidateScheduleController implements Initializable {
    private Repositories repositories = Repositories.getInstance();
    private pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();
    private EmployeeRepository employeeRepository = repositories.getEmployeeRepository();
    private AuthenticationController authenticationController;
    private ScheduleRepository scheduleRepository = repositories.getScheduleRepository();
    /**
     * The Current schedule.
     */
    Schedule currentSchedule = new Schedule();
    @FXML
    private ToggleGroup ScheduleAnswer;

    @FXML
    private Button btnSubmit;

    @FXML
    private ListView<Schedule> lvschedules;

    @FXML
    private RadioButton rbAcceptSchedule;

    @FXML
    private RadioButton rbRejectSchedule;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getScheduleList();
        authenticationController = new AuthenticationController();
        Employee agent = getLoggedAgent();
        getRequestScheduleListByResponsibleAgent(agent);
        lvschedules.getSelectionModel().selectedItemProperty().addListener(this::selectionChanged);
    }

    /**
     * Get request schedule list by responsible agent.
     *
     * @param agent the agent
     */
    public void getRequestScheduleListByResponsibleAgent(Employee agent){

        List<Schedule> scheduleList = scheduleRepository.getRequestScheduleListByResponsibleAgent(agent);
        lvschedules.getItems().addAll(scheduleList);

    }

    /**
     * Submit.
     *
     * @param event the event
     */
    @FXML
    void submit(ActionEvent event) {

        RadioButton selectedRadioButton = (RadioButton) ScheduleAnswer.getSelectedToggle();
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);

        confirmation.setTitle("CONFIRMATION");
        confirmation.setHeaderText("Are you sure you want to send this information?");

        confirmation.showAndWait().ifPresent(reponse -> {

            if (reponse == ButtonType.OK) {

                String radioButtonId = selectedRadioButton.getId();
                switch (radioButtonId) {
                    case "rbAcceptSchedule":
                        addConfirmedSchedule(currentSchedule);
                        break;
                    case "rbRejectSchedule":
                        addRejectedSchedule(currentSchedule);
                        break;
                }
            }

        });


    }


    /**
     * Add confirmed schedule boolean.
     *
     * @param schedule the schedule
     * @return the boolean
     */
    public boolean addConfirmedSchedule(Schedule schedule){
        if (schedule!=null) {
            scheduleRepository.writeObjectScheduleRequest();
            scheduleRepository.addConfirmedSchedule(currentSchedule);
            String agentName= currentSchedule.getName();
            String agentPhoneNumber= currentSchedule.getAnnouncementDTO().getAgent().getTelephoneNumber();
            Location location= currentSchedule.getAnnouncementDTO().getProperty().getLocation();
            LocalDate day= currentSchedule.getDay();
            LocalTime beginHour= currentSchedule.getBeginHour();
            LocalTime endHour=currentSchedule.getEndHour();
            sendEmail(agentName,agentPhoneNumber,location,day, beginHour, endHour,"accepted");

            return true;

        } else {
            return false;
        }

    }

    /**
     * Add rejected schedule boolean.
     *
     * @param schedule the schedule
     * @return the boolean
     */
    public boolean addRejectedSchedule(Schedule schedule){

        if (schedule!=null){
            scheduleRepository.writeObjectScheduleRequest();
            scheduleRepository.addRejectedSchedule(schedule);

            String agentName= currentSchedule.getName();
            String agentPhoneNumber= currentSchedule.getAnnouncementDTO().getAgent().getTelephoneNumber();
            Location location= currentSchedule.getAnnouncementDTO().getProperty().getLocation();
            LocalDate day= currentSchedule.getDay();
            LocalTime beginHour= currentSchedule.getBeginHour();
            LocalTime endHour=currentSchedule.getEndHour();
            sendEmail(agentName,agentPhoneNumber,location,day, beginHour, endHour,"rejected");
            return true;
        }else {
            return false;
        }
    }
    private void selectionChanged(ObservableValue<? extends Schedule> observable, Schedule oldVal, Schedule newVal) {
        currentSchedule = lvschedules.getSelectionModel().getSelectedItem();
    }

    /**
     * Send email.
     *
     * @param agentName        the agent name
     * @param agentPhoneNumber the agent phone number
     * @param location         the location
     * @param day              the day
     * @param beginHour        the begin hour
     * @param endHour          the end hour
     * @param answer           the answer
     */
    public void sendEmail(String agentName, String agentPhoneNumber, Location location, LocalDate day, LocalTime beginHour, LocalTime endHour,String answer) {
        Properties properties=new Properties();

        try {
            FileInputStream propertiesFile= new FileInputStream("src/main/resources/config.properties");
            properties.load(propertiesFile);
            String host = properties.getProperty("host");
            String emailService=properties.getProperty("emailService");
            String header = "You are sending this email with " + emailService + " service.";
            String conteudo="Hi, the request to schedule a visit to the property with the location "+location+", on the day "+day+", starting at "+beginHour+" and ending at "+endHour+", was "+answer+".";
            String footer= "With best regards, \n"+agentName+" - "+agentPhoneNumber+", responsible agent.";
            FileWriter file = new FileWriter(new File(host), true);
            file.write(header+"\n"+conteudo+"\n"+footer+"\n\n");
            file.close();
            System.out.println("File with employee credentials generated with success");

        } catch (IOException e) {

            System.out.println("Error creating file");
            e.printStackTrace();
        }
    }

    /**
     * Gets schedule list.
     *
     * @return the schedule list
     */
    public List<Schedule> getScheduleList() {
        return scheduleRepository.readObjectScheduleRequest();
    }
    private Employee getLoggedAgent() {
        String agentEmail = authenticationController.getCurrentSession().getUserEmail();
        EmployeeRepository employeeRepository = repositories.getEmployeeRepository();
        return employeeRepository.findByEmail(agentEmail);
    }
}

