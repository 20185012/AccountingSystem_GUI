package Controller;

import Model.Category;
import Model.SystemRoot;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import static Utils.CategoryUtils.*;

public class SystemRootPageController implements Initializable {

    @FXML public Button manageUsersBtn;
    @FXML public Button showSystemInfoBtn;
    @FXML public ListView rootCategoriesList;
    @FXML public MenuItem addRootCategoryBtn;
    @FXML public MenuItem deleteRootCategoryBtn;
    @FXML public Label userLabel;
    @FXML public Button accessSelectedRootCategoryBtn;
    @FXML public ListView allUsersList;
    @FXML public Label systemCreatedLabel;
    @FXML public Label systemNameLabel;
    @FXML public Label currentUserLabel;
    @FXML public Button manageUserBtn;

    private SystemRoot systemRoot;
    private User user;

    public void setSystemRoot(SystemRoot systemRoot, User user) {
        this.systemRoot = systemRoot;
        setUser(user);
        populateRootCategoriesListWithData();
        populateUsersList();

        populateLabels(systemRoot, user);
    }

    private void populateLabels(SystemRoot systemRoot, User user) {
        systemCreatedLabel.setText("System created: \n" + systemRoot.getSystemInitialDate().toString());
        systemNameLabel.setText(systemRoot.getCompanyName());
        currentUserLabel.setText("Current user: " + user.getName());
    }

    private void populateUsersList() {
        systemRoot.
                getAllUsers().
                forEach
                        (user ->
                                allUsersList.getItems().
                                        add
                                                (user.getUserID()+ ": " + user.getName()));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        userLabel.setText("User: " + user.getName());
    }


    private User getSelectedUser() {

        Object selectedUser = allUsersList.getSelectionModel().getSelectedItem();

        if (selectedUser != null) {

            String[] userData = selectedUser.toString().split(": ");

            User userToShow = systemRoot.getAllUsers().stream().filter(user -> user.getUserID().equals(userData[0])).findFirst().orElse(null);

            return userToShow;
        }
        return null;
    }

    private void populateRootCategoriesListWithData() {
        populateCategoryList(rootCategoriesList.getItems(), systemRoot.getRootCategories());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loadUserManagementForm(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/UserManagementForm.fxml"));

        Parent root = loader.load();

        UserManagementFormController userManagementFormController = loader.getController();

        User userToEdit = getSelectedUser();
        if (userToEdit != null)
        {
            userManagementFormController.setUserBeingEdited(userToEdit);
            userManagementFormController.setCurrentUser(user);
            userManagementFormController.setSystemRoot(systemRoot);

            Stage stage = (Stage) manageUserBtn.getScene().getWindow();

            stage.setTitle("Accounting system");
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    public void loadSystemInformation(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("System information");
        alert.setHeaderText(null);
        alert.setContentText(systemRoot.getDetails());
        alert.showAndWait();
    }

    public void loadRootCategoryAddDialog(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Add root category");
        dialog.setHeaderText(null);
        dialog.setContentText("Root category name: ");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent() && result.get() != "")
        {
            systemRoot.getRootCategories().add( new Category(result.get(), user, null));
            rootCategoriesList.getItems().
                    add(accessLastCategory(systemRoot.getRootCategories()).getCategoryID() + ": "
                            + accessLastCategory(systemRoot.getRootCategories()).getCategoryName());
        }
    }

    public void loadRootCategoryDeleteDialog(ActionEvent actionEvent) {
        ChoiceDialog<Category> dialog = new ChoiceDialog<Category>(systemRoot.getRootCategories().get(0),systemRoot.getRootCategories());
        dialog.setTitle("Delete root category");
        dialog.setHeaderText(null);
        dialog.setContentText("Choose root category: ");

        Optional<Category> result = dialog.showAndWait();
        if (result.isPresent())
        {
            systemRoot.getRootCategories().remove(result.get());
            rootCategoriesList.getItems().remove(result.get());
            System.out.println();
        }
    }

    public void accessSelectedRootCategory(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CategoryManagementForm.fxml"));

        Parent root = loader.load();
        CategoryManagementFormController categoryManagementFormController = loader.getController();


        Category categoryToAccess = getSelectedCategory(rootCategoriesList.getSelectionModel().getSelectedItem(),systemRoot.getRootCategories());

        if (categoryToAccess != null) {
            categoryManagementFormController.setCurrentCategory(categoryToAccess, user);
            categoryManagementFormController.setSystemRoot(systemRoot);

            System.out.println(systemRoot);

            categoryManagementFormController.setUser(user);


            Stage stage = (Stage) accessSelectedRootCategoryBtn.getScene().getWindow();

            stage.setTitle("Accounting system");
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
}
