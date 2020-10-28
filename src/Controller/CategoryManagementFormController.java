package Controller;

import Model.Category;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static Utils.CategoryUtils.getSelectedCategory;

public class CategoryManagementFormController implements Initializable {

    @FXML public Button accessSelectedCategoryBtn;
    @FXML public ListView categoryList;
    @FXML public Label userLabel;
    @FXML public Label currentUserLabel;
    @FXML public ListView responsibleUsersList;
    @FXML public Label auditDetailsLabel;
    @FXML public ListView incomeList;
    @FXML public ListView expenseList;
    @FXML public Label incomeHistoryLabel;
    @FXML public Label expensesHistoryLabel;
    @FXML public Button sellBtn;
    @FXML public Button buyBtn;

    private ArrayList<Category> categories;
    private User user;
    private Category currentCategory;



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        userLabel.setText("User: " + user.getName());
    }

    public Category getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(Category currentCategory, User user) {
        this.currentCategory = currentCategory;
        currentUserLabel.setText(user.getName());
        populateCategoriesList();
    }

    private void populateCategoriesList() {

    }


    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) { this.categories = categories; }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void accessSelectedCategory(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CategoryManagementForm.fxml"));

        Parent root = loader.load();
        CategoryManagementFormController categoryManagementFormController = loader.getController();


        categoryManagementFormController.setCurrentCategory(getSelectedCategory(categoryList.getSelectionModel(),currentCategory.getSubCategories()), user);

        categoryManagementFormController.setUser(user);


        Stage stage = (Stage) accessSelectedCategoryBtn.getScene().getWindow();

        stage.setTitle("Accounting system");
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void SellSomething(ActionEvent actionEvent) {
    }

    public void buySomething(ActionEvent actionEvent) {
    }
}
