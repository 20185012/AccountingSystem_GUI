package Controller;

import Model.IndividualUser;
import Model.SystemRoot;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {

    @FXML
    public Label registerPrompt;

    @FXML
    public Label loginPrompt;



    public void setSystemRoot(SystemRoot systemRoot) {
        this.systemRoot = systemRoot;
    }

    @FXML
    public Button loginBtn;

    @FXML
    public TextField nameTextFieldRegister;

    @FXML
    public TextField usernameTextFieldRegister;

    @FXML
    public PasswordField passwordFieldRegister;

    @FXML
    public TextField usernameTextFieldLogin;

    @FXML
    public PasswordField passwordFieldLogin;

    @FXML
    public Button registerBtn;

    private SystemRoot systemRoot;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void validateUser(ActionEvent actionEvent) throws IOException {
        if (systemRoot.getAllUsers().size() > 0)
        {
            systemRoot.
                    getAllUsers().
                    forEach(
                            user -> {
                                if (user.getLoginName().equals(usernameTextFieldLogin.getText()) &&
                                    user.getLoginPassword().equals(passwordFieldLogin.getText()))
                                {
                                    try {
                                        loadMainWindow(user);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }

            });
            loginPrompt.setText("Username or password is wrong");
            loginPrompt.setVisible(true);
        }
        else
        {
            loginPrompt.setText("There are no users in the system");
            loginPrompt.setVisible(true);
        }
    }

    private void loadMainWindow(User user) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/SystemRootPage.fxml"));

        Parent root = loader.load();

        SystemRootPageController systemRootPageController = loader.getController();
        systemRootPageController.setSystemRoot(systemRoot);
        systemRootPageController.setUser(user);

        Stage stage = (Stage) loginBtn.getScene().getWindow();

        stage.setTitle("Accounting system");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void createUser(ActionEvent actionEvent) {
            User userBeingRegistered = new IndividualUser(nameTextFieldRegister.getText(),
                                                  "someSurname",
                                                    "someEmail",
                                                   "+37068789528",
                                                          usernameTextFieldRegister.getText(),
                                                          passwordFieldRegister.getText());

            systemRoot.getAllUsers().add(userBeingRegistered);
            registerPrompt.setText("User " + userBeingRegistered.getLoginName() + " successfully signed up.");
            registerPrompt.setVisible(true);

        //systemRoot.getAllUsers().forEach(user -> user.ShowUserDetails());
    }
}
