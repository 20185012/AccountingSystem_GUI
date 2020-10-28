package Controller;

import Model.IndividualUser;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class UserManagementFormController implements Initializable {

    @FXML public Label userLabel;
    @FXML public ListView userList;
    @FXML public Button showUserInfoBtn;

    private ArrayList<User> users;

    private User user;



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        userLabel.setText("User: " + user.getName());
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
        populateUsersListWithData();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void showUserInfo(ActionEvent actionEvent) {

        User userToShow = getSelectedUser();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User information");
        alert.setHeaderText("User details");
        alert.setContentText(userToShow.UserDetails());

        alert.showAndWait();
    }

    private User getSelectedUser() {
        String[] userData = userList.getSelectionModel().getSelectedItem().toString().split(": ");

        //for (int i = 0;i<userData.length;i++) System.out.println(userData[i]);
        User userToShow = users.stream().filter(user -> user.getUserID().equals(userData[0])).findFirst().orElse(null);

        return userToShow;
    }

    private void populateUsersListWithData() {
        userList.getItems().clear();

        users.add( new IndividualUser("exampleName","ExampleSurname","example@example.lt","+37045645654","dsadsad","dsadwsad"));
        users.add( new IndividualUser("exampleName","ExampleSurname","example@example.lt","+37045645654","dsadsad","dsadwsad"));
        users.add( new IndividualUser("exampleName","ExampleSurname","example@example.lt","+37045645654","dsadsad","dsadwsad"));
        users.add( new IndividualUser("exampleName","ExampleSurname","example@example.lt","+37045645654","dsadsad","dsadwsad"));
        users.add( new IndividualUser("exampleName","ExampleSurname","example@example.lt","+37045645654","dsadsad","dsadwsad"));
        users.add( new IndividualUser("exampleName","ExampleSurname","example@example.lt","+37045645654","dsadsad","dsadwsad"));
        users.add( new IndividualUser("exampleName","ExampleSurname","example@example.lt","+37045645654","dsadsad","dsadwsad"));

        if (users.size() > 0)
        {
            users.forEach(user -> userList.getItems().add(user.getUserID() + ": " + user.getLoginName()));
        }
    }
}
