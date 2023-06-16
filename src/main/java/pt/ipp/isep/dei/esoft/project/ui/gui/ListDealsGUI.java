package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import pt.ipp.isep.dei.esoft.project.application.controller.ListDealsController;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Branch;
import pt.ipp.isep.dei.esoft.project.domain.model.Client;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.repository.AnnouncementRepository;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ListDealsGUI extends Application implements Runnable, Initializable {
    ListDealsController controller = new ListDealsController();

    @FXML
    private TableView<Announcement> tblView;


   @FXML
    private Button btnExit;
   @FXML
    private Button btnAsc;
   @FXML
    private Button btnDsc;
//    @FXML
//    private TableColumn col1;
//    @FXML
//    private TableColumn col2;





    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ListDealsGUI.class.getResource("ListDealsGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        stage.setTitle("List deals");
        stage.setScene(scene);
        stage.show();
    }



    @Override
    public void run() {
        GuiHandler.myLaunch(getClass());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TableView tblView = new TableView();

        /*
        TableColumn<Announcement, LocalDate> column1 =
                new TableColumn<>("First Name");
        column1.setCellValueFactory(
                new PropertyValueFactory<>("date"));

        TableColumn<Announcement, Client> column2 =
                new TableColumn<>("Last Name");
        column2.setCellValueFactory(
                new PropertyValueFactory<>("owner"));


        tblView.getColumns().add(column1);
        tblView.getColumns().add(column2);

        List<Announcement> announcements = ListDealsController.getDeals();
        for (Announcement a:
                announcements) {
            tblView.getItems().add(a);
        }

         */


        ObservableList<Announcement> announcements = FXCollections.observableList(controller.getDeals());

        tblView.setItems(announcements);

        TableColumn<Announcement, Date> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory("date"));

        TableColumn<Announcement, Client> clientColumn = new TableColumn<>("Client");
        clientColumn.setCellValueFactory(new PropertyValueFactory("owner"));
/*
        TableColumn<Announcement, Integer> branchIdColumn = new TableColumn<>("Branch Name");
        branchIdColumn.setCellValueFactory(data ->
                 new SimpleIntegerProperty(data.getValue().getAgent().getBranch().getID()).asObject());

 */
                //new ReadOnlyIntegerWrapper(data.getValue().getAgent().getBranch().getID()));

        //branchIdColumn.setCellValueFactory(data -> data.getValue().getAgent().getBranch().getID());


        TableColumn<Announcement, String> branchNameColumn = new TableColumn<>("Branch Name");
        branchNameColumn.setCellValueFactory(data ->
                new ReadOnlyStringWrapper(data.getValue().getAgent().getBranch().getName()));

        //tblView.getColumns().setAll(dateColumn, clientColumn, branchIdColumn, branchNameColumn);
        tblView.getColumns().setAll(dateColumn, clientColumn, branchNameColumn);

        return;
    }
}
