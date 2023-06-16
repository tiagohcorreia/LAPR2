# US 016 - To validate an appointment for a visit

# 4. Tests 

**Pre-Test:** 

	static ScheduleRepository scheduleRepository;
    private AuthenticationRepository authenticationRepository;
    ScheduleVisitController scheduleVisitController;
    ValidateScheduleController validateScheduleController;
    private EmployeeRepository employeeRepository;
    AnnouncementDTO announcementDTO;
    AnnouncementDTO announcementDTO2;
    LocalDate day;
    LocalTime beginHour;
    LocalTime endHour;

    LocalDate day2;
    LocalTime beginHour2;
    LocalTime endHour2;
    LocalTime beginHour3;
    LocalTime endHour3;
    AuthFacade authenticationFacade= new AuthFacade();;
    Schedule scheduleToAdd;
    Employee e1;
    Employee e2;
    Schedule schedule1;
    Schedule schedule2;
    Schedule schedule3;
    @BeforeAll
    static void setup() {
        scheduleRepository = Repositories.getInstance().getScheduleRepository();

    }

    @BeforeEach
    void init() {

        authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        employeeRepository= Repositories.getInstance().getEmployeeRepository();
        scheduleVisitController = new ScheduleVisitController(scheduleRepository);
        validateScheduleController = new ValidateScheduleController();
        Branch branch = new Branch();
        ArrayList<String> photographs = new ArrayList<String>();
        photographs.add("photo1");
        City city = new City("Porto");
        day = LocalDate.of(2024, 06, 20);
        beginHour = LocalTime.of(12, 30, 0);
        endHour = LocalTime.of(13, 30, 0);
        day2 = LocalDate.of(2024, 06, 20);
        beginHour2 = LocalTime.of(14, 30, 0);
        endHour2 = LocalTime.of(15, 30, 0);
        beginHour3 = LocalTime.of(16, 30, 0);
        endHour3 = LocalTime.of(17, 30, 0);
        Property property = new Land(123, new Location(), 123, photographs);
        e1 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e1@gmail.com", String.valueOf(1234567891), Role.AGENT, branch);
        e2 = new Employee("Employee", 123456789, 123456789, "Rua 1", "e2@gmail.com", String.valueOf(1234567891), Role.AGENT, branch);

        Client owner = new Client("owner1", "owner@this.app", 123456789, 111111111, 1234567890);

        Announcement announcement = new Announcement(LocalDate.now(), AnnouncementStatus.PUBLISHED, 1231, 121, TypeOfBusiness.SELL, property, e1, owner);
        Announcement announcement2 = new Announcement(LocalDate.now(), AnnouncementStatus.PUBLISHED, 1231, 121, TypeOfBusiness.SELL, property, e2, owner);

        announcementDTO = new AnnouncementDTO(123, TypeOfBusiness.SELL, property, e1);
        announcementDTO2 = new AnnouncementDTO(123, TypeOfBusiness.SELL, property, e2);
        schedule1= new Schedule("vitor", 1234567891, announcementDTO, day, beginHour, endHour, "no more notes", false, false);
        schedule2= new Schedule("vitor2", 1224567891, announcementDTO2, day, beginHour, endHour, "no more notes2", false, false);
        scheduleRepository.getScheduleList().clear();
        scheduleRepository.getRequestScheduleListByResponsibleAgent(e1).clear();
        scheduleRepository.getRequestScheduleListByResponsibleAgent(e2).clear();
    }
	

**Test 2:** Check if the Schedule is registered as validated

	@Test
    void addConfirmedSchedule() {
        scheduleRepository.addSchedule(schedule1);
        Schedule schedule= new Schedule("vitor", 1234567891, announcementDTO, day, beginHour, endHour, "no more notes", true, true);
        scheduleRepository.getRequestScheduleListByResponsibleAgent(e1);

        validateScheduleController.addConfirmedSchedule(0);
        List<Schedule> expectedConfirmedScheduleList = new ArrayList<>();
        expectedConfirmedScheduleList.add(schedule);
        assertEquals(expectedConfirmedScheduleList, scheduleRepository.getRequestScheduleListByResponsibleAgent(e1));
    }

**Test 3:** Check if the Schedule is registered as rejected

	@Test
    void addRejectedSchedule() {
        scheduleRepository.addSchedule(schedule2);
        Schedule schedule= new Schedule("vitor2", 1224567891, announcementDTO2, day, beginHour, endHour, "no more notes2", true, false);
        scheduleRepository.getRequestScheduleListByResponsibleAgent(e2);
        validateScheduleController.addRejectedSchedule(0);
        List<Schedule> expectedRejectedScheduleList = new ArrayList<>();
        expectedRejectedScheduleList.add(schedule);
        assertEquals(expectedRejectedScheduleList, scheduleRepository.getRequestScheduleListByResponsibleAgent(e2));
    }

**Test 4:** Check if the system gets the list with schedules by responsible agent

	@Test
    void getRequestScheduleListByResponsibleAgent() {

        employeeRepository.saveEmployeeInTheSystem(e1,"pwd");
        authenticationRepository.doLogin("e1@gmail.com","pwd");

        List<Schedule> expectedScheduleList = new ArrayList<>();
        expectedScheduleList.add(new Schedule("vitor", 1234567891, announcementDTO, day, beginHour, endHour, "no more notes", false, false));

        List<Schedule> result = validateScheduleController.getRequestScheduleListByResponsibleAgent();
        System.out.println(result);
        assertEquals(expectedScheduleList, result);


*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class ValidateScheduleController 

```java
public class ValidateScheduleController implements Initializable {

    Repositories repositories = Repositories.getInstance();
    private ScheduleRepository scheduleRepository= repositories.getScheduleRepository();
    private pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();
    private EmployeeRepository employeeRepository = repositories.getEmployeeRepository();

    @FXML
    private ToggleGroup ScheduleAnswer;

    @FXML
    private Button btnSubmit;

    @FXML
    private RadioButton rbAcceptSchedule;

    @FXML
    private RadioButton rbRejectSchedule;

    @FXML
    private TableColumn<Schedule, LocalTime> rowBeginHour;

    @FXML
    private TableColumn<Schedule, String> rowClientName;

    @FXML
    private TableColumn<Schedule, LocalDate> rowDay;

    @FXML
    private TableColumn<Schedule, LocalTime> rowEndHour;

    @FXML
    private TableColumn<Location,String> rowLocation;

    @FXML
    private TableColumn<Schedule, String> rowNote;

    @FXML
    private TableColumn<AnnouncementDTO, Float> rowPrice;

    @FXML
    private TableColumn<TypeOfBusiness, String> rowTypeOfBusiness;

    @FXML
    private TableView<Schedule> tblScheduleList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Schedule> scheduleList = getRequestScheduleListByResponsibleAgent();
        for (Schedule schedule:scheduleList){
            rowClientName.setText(schedule.getName());
            rowTypeOfBusiness.setText(String.valueOf(schedule.getAnnouncementDTO().getTypeOfBusiness()));
            rowPrice.setText(String.valueOf(schedule.getAnnouncementDTO().getPrice()));
            rowLocation.setText(String.valueOf(schedule.getAnnouncementDTO().getProperty().getLocation()));
            rowDay.setText(String.valueOf(schedule.getDay()));
            rowBeginHour.setText(String.valueOf(schedule.getBeginHour()));
            rowEndHour.setText(String.valueOf(schedule.getEndHour()));
            rowNote.setText(schedule.getNoteFromAgent());
        }
    }
    @FXML
    private void submit() {
        Schedule selectedSchedule = tblScheduleList.getSelectionModel().getSelectedItem();
        if (selectedSchedule != null) {
            int schedulePos = tblScheduleList.getItems().indexOf(selectedSchedule);
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
        }
    }

    public List<Schedule> getRequestScheduleListByResponsibleAgent(){
        scheduleRepository.readObjectScheduleRequest();
        String agentName=String.valueOf(authenticationRepository.getCurrentUserSession().getUserName());
        pt.ipp.isep.dei.esoft.project.domain.model.Employee agent= employeeRepository.findByName(agentName);
        List<Schedule> scheduleList= scheduleRepository.getRequestScheduleListByResponsibleAgent(agent);
        return scheduleList;
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
```


## Class ValidateScheduleGUI

```java
public class ValidateScheduleGUI extends Application implements Runnable{


    ValidateScheduleController controller = new ValidateScheduleController();

    @Override
    public void start(Stage stage) throws IOException {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(ValidateScheduleGUI.class.getResource("ValidateSchedule.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            stage.setTitle("US016");
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

                @Override
                public void handle(WindowEvent event) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                    alert.setTitle("Application");
                    alert.setHeaderText("Confirm");
                    alert.setContentText("Do you really want to close?");

                    ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Yes");
                    ((Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("No");

                    if (alert.showAndWait().get() == ButtonType.CANCEL) {

                        event.consume();
                    }
                }
            });
            stage.show();

        } catch (IOException ex) {

            createErrorAlert(ex).show();
        }
    }

    public static void main(final String[] args) {
        launch();
    }

    @Override
    public void run() {
        GuiHandler.myLaunch(getClass());
    }

    private Alert createErrorAlert(Exception ex) {

        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Application");
        alert.setHeaderText("Problems starting application");
        alert.setContentText(ex.getMessage());

        return alert;
    }

}
```
## Class ScheduleRepository 
```java
public class ScheduleRepository {
    public static List<Schedule> scheduleList = new ArrayList<>();
    public static List<Schedule> schedulesByResposibleAgent= new ArrayList<>();


    public boolean saveSchedule(Schedule schedule){
        if(validateSchedule(schedule)) {
            return addSchedule(schedule);
        }
        return false;
    }
    public boolean validateSchedule(Schedule schedule){
        for(Schedule schedule1: scheduleList) {

            if(schedule.equals(schedule1)) {
                return false;
            }
        }
        return true;
    }

    public boolean addSchedule(Schedule schedule){
        if(schedule != null && validateSchedule(schedule)) {

            return this.scheduleList.add(schedule);
        }
        return false;
    }

    public List<Schedule> getScheduleList() {

        return new ArrayList<>(scheduleList);
    }

    public String getScheduleListAsString() {

        StringBuilder stringBuilder = new StringBuilder();

        for(Schedule schedule: this.scheduleList) {

            stringBuilder.append("-").append(schedule.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
    public List<Schedule> readObjectScheduleRequest() {

        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ser/schedulesRequests.ser"));
            scheduleList = (List<Schedule>) ois.readObject();
            System.out.println(scheduleList);
            ois.close();

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();
        }
        return scheduleList;
    }

    /**
     * Write object.
     */
    public void writeObjectScheduleRequest() {

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ser/schedulesRequests.ser"));
            oos.writeObject(scheduleList);
            oos.close();

        } catch (IOException ioe) {

            ioe.printStackTrace();
        }
    }

    public List<Schedule> getRequestScheduleListByResponsibleAgent(Employee agent){

        for (Schedule schedule:this.scheduleList){
            if (schedule.getAnnouncementDTO().getAgent().equals(agent) && schedule.getStatus()!=true){
                schedulesByResposibleAgent.add(schedule);
            }
        }
        return schedulesByResposibleAgent;
    }

    public boolean addConfirmedSchedule(Schedule schedule){
        for (Schedule schedule1:this.scheduleList){
            if (schedule1.equals(schedule)){
                schedule1.setStatus(true);
                schedule1.setAproved(true);
                return true;
            }
        }
        return false;
    }
    public boolean addRejectedSchedule(Schedule schedule){
        for (Schedule schedule1:this.scheduleList){
            if (schedule1.equals(schedule)){
                schedule1.setStatus(true);
                schedule1.setAproved(false);
                return true;
            }
        }
        return false;
    }
}
```
# 6. Integration and Demo 

* A new option on the Agent menu options was added.


# 7. Observations

N/A





