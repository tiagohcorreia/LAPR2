# US 014 - Appointment Management 

# 5. Construction (Implementation)


## Class Class ReadResponseOfAppointmentRequestGUI

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







