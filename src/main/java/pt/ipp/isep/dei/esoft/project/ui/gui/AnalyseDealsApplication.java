package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnalyseDealsApplication extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("AnalyseDeals.fxml"));
            primaryStage.setTitle("Analyse Deals");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }