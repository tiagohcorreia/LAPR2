package pt.ipp.isep.dei.esoft.project.application.controller;
import pt.ipp.isep.dei.esoft.project.domain.model.Location;
import pt.ipp.isep.dei.esoft.project.domain.model.Schedule;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.repository.ScheduleRepository;
import pt.ipp.isep.dei.esoft.project.utils.FileOps;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Properties;
import java.util.logging.FileHandler;

import static pt.ipp.isep.dei.esoft.project.domain.shared.PasswordGenerator.generatePassword;

public class ValidateScheduleController {

    Repositories repositories = Repositories.getInstance();
    private AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();
    private ScheduleRepository scheduleRepository= repositories.getScheduleRepository();
    private pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();
    private EmployeeRepository employeeRepository = repositories.getEmployeeRepository();

    public ValidateScheduleController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    public List<Schedule> getRequestScheduleListByResponsibleAgent(){
        String agentName=String.valueOf(authenticationRepository.getCurrentUserSession().getUserName());
        pt.ipp.isep.dei.esoft.project.domain.model.Employee agent= employeeRepository.findByName(agentName);
        return scheduleRepository.getRequestScheduleListByResponsibleAgent(agent);
    }
    public boolean addConfirmedSchedule(int schedulePos){
        if (schedulePos>=0 && schedulePos< scheduleRepository.schedulesByResposibleAgent.size()){
            Schedule schedule= scheduleRepository.schedulesByResposibleAgent.get(schedulePos);
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
        }else {
            return false;
        }
    }
    public boolean addRejectedSchedule(int schedulePos){
        if (schedulePos>=0 && schedulePos< scheduleRepository.schedulesByResposibleAgent.size()){
            Schedule schedule= scheduleRepository.schedulesByResposibleAgent.get(schedulePos);
            scheduleRepository.writeObjectScheduleRequest();
            scheduleRepository.addRejectedSchedule(schedule);

            String agentName= schedule.getAnnouncementDTO().getAgent().getName();
            String agentPhoneNumber= schedule.getAnnouncementDTO().getAgent().getTelephoneNumber();
            Location location= schedule.getAnnouncementDTO().getProperty().getLocation();
            LocalDate day= schedule.getDay();
            LocalTime beginHour= schedule.getBeginHour();
            LocalTime endHour=schedule.getEndHour();
            sendEmail(agentName,agentPhoneNumber,location,day, beginHour, endHour,"rejected");
            return true;
        }else {
            return false;
        }
    }

    public String sendEmail(String agentName, String agentPhoneNumber, Location location, LocalDate day, LocalTime beginHour, LocalTime endHour,String answer) {
        Properties properties=new Properties();
        try {
            FileInputStream propertiesFile= new FileInputStream("resources/config.properties");
            properties.load(propertiesFile);

            String host = properties.getProperty("host");
            String emailService=properties.getProperty("emailService");
            String header = "You are sending this email with " + emailService + " service.";
            String conteudo="Hi, the request to schedule a visit to the property with the location "+location+", on the day "+day+", starting at "+beginHour+" and ending at "+endHour+", was "+answer+".";
            String footer= "With best regards, \n"+agentName+" - "+agentPhoneNumber+", responsible agent.";
            FileWriter file = new FileWriter(new File(host),true);
            file.write(header+"\n"+conteudo+"\n"+footer+"\n\n");
            file.close();
            System.out.println("File with employee credentials generated with success");

        } catch (IOException e) {

            System.out.println("Error creating file");
            e.printStackTrace();
        }
        return null;
    }
}
