# US 020 - As a client, I want to read the response for the appointment request, to accept or reject it

# 4. Tests 

**Test 1:** 

	

**Test 2:** 



# 5. Construction (Implementation)


## Class ReadResponseOfAppointmentRequestGUI 

```java
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
       
    }

    public List<Schedule> getScheduleList() {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

    public void sendNotificationToAgent() {
        
    }

}
```


## Class ReadResponseOfAppointmentRequestController

```java
public class ReadResponseOfAppointmentRequestGUI extends Application implements Runnable {

    ReadResponseOfAppointmentRequestController controller = new ReadResponseOfAppointmentRequestController();

    @Override
    public void start(Stage stage) throws IOException {
        
    }

    public static void main(final String[] args) {
        
    }

    @Override
    public void run() {
        
    }

    private Alert createErrorAlert(Exception ex) {
        
    }
}


```

## Class Repositories

```java
public class Repositories {

    private static final pt.ipp.isep.dei.esoft.project.domain.repository.Repositories instance = new pt.ipp.isep.dei.esoft.project.domain.repository.Repositories();
    

    public static pt.ipp.isep.dei.esoft.project.domain.repository.Repositories getInstance() {
    }
    
    public ScheduleRepository getScheduleRepository() {return scheduleRepository;}
}

```

## Class Schedule

```java
public class Schedule {
    
    private String name;
    private int phoneNumber;
    private AnnouncementDTO announcementDTO;
    private LocalDate day;
    private LocalTime beginHour;
    private LocalTime endHour;
    private String note;
    private boolean status; 
    private boolean aproved;

    public Schedule(String name, int phoneNumber, AnnouncementDTO announcementDTO, LocalDate day, LocalTime beginHour,LocalTime endHour, String note, boolean status, boolean aproved) {
    }

    public String getName() {
    }

    public int getPhoneNumber() {
    }

    public AnnouncementDTO getAnnouncementDTO() {
    }

    public LocalDate getDay() {
    }

    public LocalTime getBeginHour() {
    }
    
    public LocalTime getEndHour() {
    }

    public String getNote() {
    }
    
    public boolean getStatus(){
    }
    
    public boolean getAproved(){
    }

    public String setName(String name) {
    }
    
    public Integer setPhoneNumber(int phoneNumber) {
    }

    public AnnouncementDTO setAnnouncementDTO(AnnouncementDTO announcementDTO) {
    }

    public LocalDate setDay(LocalDate day) {
    }

    public LocalTime setBeginHour(LocalTime beginHour) {
    }
    public LocalTime setEndHour(LocalTime endHour) {
    }

    public String setNote(String note) {
    }

    public boolean setStatus(boolean status) {
    }

    public boolean setAproved(boolean aproved) {
    }

    @Override
    public boolean equals(Object o) {
    }

    @Override
    public int hashCode() {
    }

    @Override
    public String toString() {
    }

}
```

## Class ScheduleRepository

```java
public class ScheduleRepository {
    
    public static List<Schedule> scheduleList = new ArrayList<>();
    public static List<Schedule> schedulesByResposibleAgent= new ArrayList<>();
    
    public boolean validateSchedule(Schedule schedule){
    }

    public boolean addSchedule(Schedule schedule){
    }

    public List<Schedule> getScheduleList() {
    }

    public String getScheduleListAsString() {
    }
    
    public List<Schedule> readObjectScheduleRequest() {
    }

    public void writeObjectScheduleRequest() {
    }

    public List<Schedule> getRequestScheduleListByResponsibleAgent(Employee agent){
    }

    public boolean addConfirmedSchedule(Schedule schedule){
    }
    
    public boolean addRejectedSchedule(Schedule schedule){
    }
}
```

# 6. Integration and Demo 


* A new option on the Client menu added.


# 7. Observations

* N/A





