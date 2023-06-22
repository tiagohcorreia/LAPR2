package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;

import pt.ipp.isep.dei.esoft.project.application.controller.ListDealsController;
import pt.ipp.isep.dei.esoft.project.domain.dto.DealsDto;
import pt.ipp.isep.dei.esoft.project.domain.shared.SortingOrder;


import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ListDealsGUI extends Application implements Runnable, Initializable {
    static final String HEADER_TEXT = "DATE \t\tPRICE \t\tSELLER NAME";

    private ListDealsController controller = new ListDealsController();

    private List<DealsDto> deals = new ArrayList<>();

    @FXML
    private Button btnAsc;

    @FXML
    private Button btnDsc;

    @FXML
    private RadioButton rdbBubble;

    @FXML
    private RadioButton rdbInsertion;

    @FXML
    private TextArea txtArea;

    @FXML
    void sortWithAlgorithm(ActionEvent event) {
        String algorithm = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
        SortingOrder sortingOrder;
        if (((Button) event.getSource()).getText().equals("Ascending"))
            sortingOrder = SortingOrder.ASCENDING;
        else
            sortingOrder = SortingOrder.DESCENDING;

        controller.sortDealsWithAlgorithm(deals, algorithm, sortingOrder);
        printDeals();
    }

    ToggleGroup toggleGroup = new ToggleGroup();



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ListDealsGUI.class.getResource("ListDealsGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
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
        rdbBubble.setToggleGroup(toggleGroup);
        rdbInsertion.setToggleGroup(toggleGroup);

        deals = controller.getDeals();
        controller.sortDealsByDate(deals, SortingOrder.DESCENDING);

        printDeals();
    }
    public void printHeader(){
        txtArea.setText("");
        txtArea.appendText(HEADER_TEXT);
        txtArea.appendText("\n");
    }

    private void printDeals(){
        printHeader();
        for (DealsDto d:
                deals) {
            txtArea.appendText(d.toString());
            txtArea.appendText("\n");
        }
    }

}
