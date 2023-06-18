package pt.ipp.isep.dei.esoft.project.application.controller;

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



public class ValidateScheduleController implements Initializable {
    private Repositories repositories = Repositories.getInstance();
    private pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();
    private EmployeeRepository employeeRepository = repositories.getEmployeeRepository();
    private AuthenticationController authenticationController;
    private ScheduleRepository scheduleRepository = repositories.getScheduleRepository();
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

    @FXML
    void submit(ActionEvent event) {
        Alert accepted= new Alert(Alert.AlertType.CONFIRMATION);
        accepted.setTitle("Accepted");
       /*Schedule selectedSchedule = lvschedules.getSelectionModel().getSelectedItem();

        if (selectedSchedule != null) {

            int schedulePos = lvschedules.getItems().indexOf(selectedSchedule);
            RadioButton selectedRadioButton = (RadioButton) ScheduleAnswer.getSelectedToggle();

            if (selectedRadioButton != null) {
                String radioButtonId = selectedRadioButton.getId();
                switch (radioButtonId) {
                    case "rbAcceptSchedule":
                        addConfirmedSchedule(schedulePos);
                        break;
                    case "rbRejectSchedule":
                        addRejectedSchedule(schedulePos);
                        break;
                }
            }
        }*/
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getScheduleList();
        authenticationController = new AuthenticationController();
        Employee agent = getLoggedAgent();
        getRequestScheduleListByResponsibleAgent(agent);
    }
    public void getRequestScheduleListByResponsibleAgent(Employee agent){

        //List<Schedule> scheduleList = scheduleRepository.getRequestScheduleListByResponsibleAgent(agent);

        lvschedules.getItems().addAll(getScheduleList());

    }
    private Employee getLoggedAgent() {
        String agentEmail = authenticationController.getCurrentSession().getUserEmail();
        EmployeeRepository employeeRepository = repositories.getEmployeeRepository();
        return employeeRepository.findByEmail(agentEmail);
    }
    public Alert addConfirmedSchedule(int schedulePos){
        Alert accepted= new Alert(Alert.AlertType.CONFIRMATION);
        accepted.setTitle("Accepted");
        /*if (schedulePos>=0  && schedulePos < lvschedules.getItems().size()) {

            Schedule schedule= lvschedules.getItems().get(schedulePos);
            scheduleRepository.writeObjectScheduleRequest();
            scheduleRepository.addConfirmedSchedule(schedule);

            String agentName= schedule.getAnnouncementDTO().getAgent().getName();
            String agentPhoneNumber= schedule.getAnnouncementDTO().getAgent().getTelephoneNumber();
            Location location= schedule.getAnnouncementDTO().getProperty().getLocation();
            LocalDate day= schedule.getDay();
            LocalTime beginHour= schedule.getBeginHour();
            LocalTime endHour=schedule.getEndHour();
            sendEmail(agentName,agentPhoneNumber,location,day, beginHour, endHour,"accepted");

            return true;

        } else {
            return false;
        }*/
        return accepted;
    }

    public Alert addRejectedSchedule(int schedulePos){
        Alert rejected= new Alert(Alert.AlertType.CONFIRMATION);
        rejected.setTitle("Rejected");
        /*if (schedulePos>=0 && schedulePos < lvschedules.getItems().size() ){
            Schedule schedule= lvschedules.getItems().get(schedulePos);
            scheduleRepository.writeObjectScheduleRequest();
            scheduleRepository.addRejectedSchedule(schedule);

            /*String agentName= schedule.getAnnouncementDTO().getAgent().getName();
            String agentPhoneNumber= schedule.getAnnouncementDTO().getAgent().getTelephoneNumber();
            Location location= schedule.getAnnouncementDTO().getProperty().getLocation();
            LocalDate day= schedule.getDay();
            LocalTime beginHour= schedule.getBeginHour();
            LocalTime endHour=schedule.getEndHour();
            sendEmail(agentName,agentPhoneNumber,location,day, beginHour, endHour,"rejected");
            return true;
        }else {
            return false;
        }*/
        return rejected;
    }

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
    public List<Schedule> getScheduleList() {
        return scheduleRepository.readObjectScheduleRequest();
    }
}

