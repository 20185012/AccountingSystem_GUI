package Controller;

import Model.User;
import Model.UserType;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class UserManagementFormController implements Initializable {

    public Label userLabel;
    public TextField nameTextField;
    public Button nameEditBtn;
    public TextField surnameTextField;
    public Button surnameEditBtn;
    public TextField emailTextField;
    public Button emailEditBtn;
    public TextField usernameTextField;
    public Button usernameEditBtn;
    public TextField passwordTextField;
    public Button passwordEditBtn;
    public TextField addressTextField;
    public Button addressEditBtn;
    public TextField companyCodeTextField;
    public Button companyCodeEditBtn;
    public Button nameConfirmBtn;
    public Button surnameConfirmBtn;
    public Button emailConfirmBtn;
    public Button usernameConfirmBtn;
    public Button passwordConfirmBtn;
    public Button addressConfirmBtn;
    public Button companyCodeConfirmBtn;
    public TextField phoneTextField;
    public Button phoneEditBtn;
    public Button phoneConfirmBtn;



    private User currentUser;
    private User userBeingEdited;




    public User getUserBeingEdited() {
        return userBeingEdited;
    }

    public void setUserBeingEdited(User userBeingEdited) {
        this.userBeingEdited = userBeingEdited;

        nameTextField.setText(userBeingEdited.getName());
        nameTextField.setEditable(false);
        nameConfirmBtn.setDisable(true);

        emailTextField.setText(userBeingEdited.getEmail());
        emailTextField.setEditable(false);
        emailConfirmBtn.setDisable(true);

        phoneTextField.setText(userBeingEdited.getPhone());
        phoneTextField.setEditable(false);
        phoneConfirmBtn.setDisable(true);

        usernameTextField.setText(userBeingEdited.getLoginName());
        usernameTextField.setEditable(false);
        usernameConfirmBtn.setDisable(true);

        passwordTextField.setText(userBeingEdited.getLoginPassword());
        passwordTextField.setEditable(false);
        passwordConfirmBtn.setDisable(true);

        if (userBeingEdited.getUserType() == UserType.Individual)
        {
            companyCodeTextField.setText("User is individual");
            companyCodeTextField.setEditable(false);
            companyCodeEditBtn.setDisable(true);
            companyCodeConfirmBtn.setDisable(true);

            addressTextField.setText("User is individual");
            addressTextField.setEditable(false);
            addressEditBtn.setDisable(true);
            addressConfirmBtn.setDisable(true);

            surnameTextField.setText(userBeingEdited.getSurname());
            surnameTextField.setEditable(false);
            surnameConfirmBtn.setDisable(true);
        }
        else
        {
            surnameTextField.setText("User is legal");
            surnameTextField.setEditable(false);
            surnameEditBtn.setDisable(true);
            surnameConfirmBtn.setDisable(true);


            companyCodeTextField.setText(userBeingEdited.getCompanyCode());
            companyCodeTextField.setEditable(false);
            companyCodeConfirmBtn.setDisable(true);

            addressTextField.setText(userBeingEdited.getAddress());
            addressTextField.setEditable(false);
            addressConfirmBtn.setDisable(true);
        }
    }



    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
        userLabel.setText("User: " + user.getName());
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

/*
    private User getSelectedUser() {
        String[] userData = userList.getSelectionModel().getSelectedItem().toString().split(": ");

        //for (int i = 0;i<userData.length;i++) System.out.println(userData[i]);
        User userToShow = users.stream().filter(user -> user.getUserID().equals(userData[0])).findFirst().orElse(null);

        return userToShow;
    }
*/
    /*
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
*/
    public void editName(ActionEvent actionEvent) {
        nameTextField.setEditable(true);
        nameConfirmBtn.setDisable(false);
    }

    public void editSurname(ActionEvent actionEvent) {
        surnameTextField.setEditable(true);
        surnameConfirmBtn.setDisable(false);
    }

    public void editEmail(ActionEvent actionEvent) {
        emailTextField.setEditable(true);
        emailConfirmBtn.setDisable(false);
    }

    public void editUsername(ActionEvent actionEvent) {
        usernameTextField.setEditable(true);
        usernameConfirmBtn.setDisable(false);
    }

    public void editPassword(ActionEvent actionEvent) {
        passwordTextField.setEditable(true);
        passwordConfirmBtn.setDisable(false);
    }

    public void editAddress(ActionEvent actionEvent) {
        addressTextField.setEditable(true);
        addressConfirmBtn.setDisable(false);
    }

    public void editCompanyCode(ActionEvent actionEvent) {
        companyCodeTextField.setEditable(true);
        companyCodeConfirmBtn.setDisable(false);
    }

    public void confirmName(ActionEvent actionEvent) {
        userBeingEdited.setName(nameTextField.getText());
        nameTextField.setEditable(false);
        nameConfirmBtn.setDisable(true);
    }

    public void confirmSurname(ActionEvent actionEvent) {
        userBeingEdited.setSurname(surnameTextField.getText());
        surnameTextField.setEditable(false);
        surnameConfirmBtn.setDisable(true);
    }

    public void confirmEmail(ActionEvent actionEvent) {
        userBeingEdited.setEmail(emailTextField.getText());
        emailTextField.setEditable(false);
        emailConfirmBtn.setDisable(true);
    }

    public void confirmUsername(ActionEvent actionEvent) {
        userBeingEdited.setLoginName(usernameTextField.getText());
        usernameTextField.setEditable(false);
        usernameConfirmBtn.setDisable(true);
    }

    public void confirmPassword(ActionEvent actionEvent) {
        userBeingEdited.setLoginPassword(passwordConfirmBtn.getText());
        passwordTextField.setEditable(false);
        passwordConfirmBtn.setDisable(true);
    }

    public void confirmAddress(ActionEvent actionEvent) {
        userBeingEdited.setAddress(addressTextField.getText());
        addressTextField.setEditable(false);
        addressConfirmBtn.setDisable(true);
    }

    public void confirmCompanyCode(ActionEvent actionEvent) {
        userBeingEdited.setCompanyCode(companyCodeTextField.getText());
        companyCodeTextField.setEditable(false);
        companyCodeConfirmBtn.setDisable(true);
    }

    public void editPhone(ActionEvent actionEvent) {
        phoneTextField.setEditable(true);
        passwordConfirmBtn.setDisable(false);
    }

    public void confirmPhone(ActionEvent actionEvent) {
        userBeingEdited.setPhone(phoneTextField.getText());
        phoneTextField.setEditable(false);
        phoneConfirmBtn.setDisable(true);
    }
}
