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
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import static Utils.CategoryUtils.accessLastCategory;

public class SystemRootPageController implements Initializable {

    @FXML public Button manageCategoriesBtn;
    @FXML public Button manageUsersBtn;
    @FXML public Button showSystemInfoBtn;
    @FXML public Button exitBtn;
    @FXML public ListView rootCategoriesList;
    @FXML public MenuItem addRootCategoryBtn;
    @FXML public MenuItem deleteRootCategoryBtn;
    public Label userLabel;

    private SystemRoot systemRoot;
    private User user;

    public void setSystemRoot(SystemRoot systemRoot) {
        this.systemRoot = systemRoot;
        populateRootCategoriesListWithData();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        userLabel.setText("User: " + user.getName());
    }




    private void populateRootCategoriesListWithData() {
        systemRoot.
                getRootCategories().
                forEach
                        (category ->
                                rootCategoriesList.getItems().
                                        add
                                                (category.getCategoryName() + ": " + category.getOverallFinances()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loadRootCategoriesManagementForm(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CategoryManagementForm.fxml"));

        Parent root = loader.load();

        CategoryManagementFormController categoryManagementFormController = loader.getController();
        categoryManagementFormController.setCategories(systemRoot.getRootCategories());
        categoryManagementFormController.setUser(user);

        Stage stage = (Stage) manageCategoriesBtn.getScene().getWindow();

        stage.setTitle("Accounting system");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void loadUsersManagementForm(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/UsersManagementForm.fxml"));

        Parent root = loader.load();

        UserManagementFormController userManagementFormController = loader.getController();
        userManagementFormController.setUsers(systemRoot.getAllUsers());

        Stage stage = (Stage) manageUsersBtn.getScene().getWindow();

        stage.setTitle("Accounting system");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void loadSystemInformation(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("System information");
        alert.setHeaderText(null);
        alert.setContentText(systemRoot.getDetails());
        alert.showAndWait();
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void loadRootCatogoryAddDialog(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Add root category");
        dialog.setHeaderText(null);
        dialog.setContentText("Root category name: ");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent() && result.get() != "")
        {
            systemRoot.getRootCategories().add( new Category(result.get(), user, null));
            rootCategoriesList.getItems().
                    add(accessLastCategory(systemRoot.getRootCategories()).getCategoryName()
                            + "\nBalance: "
                            + accessLastCategory(systemRoot.getRootCategories()).getOverallFinances());
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
}
