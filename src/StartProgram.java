import Controller.LoginPageController;
import Model.SystemRoot;
import Utils.DataRW;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartProgram extends Application {

    SystemRoot systemRoot = new SystemRoot("System");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/LoginPage.fxml"));

        Parent root = loader.load();

        systemRoot = DataRW.LoadSystemFromFile(systemRoot);
        if (systemRoot.getAllUsers().size() > 0)
        {
            System.out.println("Data successfully loaded.");
        }

        LoginPageController loginPageController = loader.getController();
        loginPageController.setSystemRoot(systemRoot);

        primaryStage.setTitle("Accounting system");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
