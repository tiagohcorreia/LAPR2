package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.AnalyseDealsController;
import pt.ipp.isep.dei.esoft.project.application.controller.AnalyseDealsController.PropertyData;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The type Analyse deals application.
 */
public class AnalyseDealsApplication extends Application implements Runnable, Initializable {

        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("AnalyseDeals.fxml"));
            primaryStage.setTitle("Analyse Deals");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
            launch(args);
        }

    @Override
    public void run() {
        GuiHandler.myLaunch(getClass());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}