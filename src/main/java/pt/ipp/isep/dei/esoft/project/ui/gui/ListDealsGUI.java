package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

import java.io.IOException;
import java.util.List;

public class ListDealsGUI extends Application implements Runnable {
    ListDealsController controller = new ListDealsController();

    @FXML
    private TableView<Announcement> tblView;


   @FXML
    private Button btnExit;
   @FXML
    private Button btnAsc;
   @FXML
    private Button btnDsc;
    @FXML
    private TableColumn col1;
    @FXML
    private TableColumn col2;





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

        TableView tableView = new TableView();

        TableColumn<Announcement, String> column1 =
                new TableColumn<>("First Name");

        column1.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));


        TableColumn<Announcement, String> column2 =
                new TableColumn<>("Last Name");

        column2.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));



        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        List<Announcement> announcements = ListDealsController.getDeals();
        for (Announcement a:
                announcements) {
            tableView.getItems().add(a);
        }





    }



    @Override
    public void run() {
        GuiHandler.myLaunch(getClass());
    }
}
