package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class ReadResponseOfAppointmentRequestGUI extends Application implements Runnable {

    @Override
    public void start(Stage stage) throws IOException {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(ReadResponseOfAppointmentRequestGUI.class.getResource("ReadAppointmentRequest.fxml"));
            //Parent root = fxmlLoader.load();
            Scene scene = new Scene(fxmlLoader.load());

            stage.setTitle("US020");
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
        //Application.launch(ReadResponseOfAppointmentRequestGUI.class, args);
    }

    private Alert createErrorAlert(Exception ex) {

        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Application");
        alert.setHeaderText("Problems starting application");
        alert.setContentText(ex.getMessage());

        return alert;
    }

    @Override
    public void run() {
        launch();
    }
}
