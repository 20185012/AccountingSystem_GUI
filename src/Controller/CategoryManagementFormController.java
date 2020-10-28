package Controller;

import Model.Category;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CategoryManagementFormController implements Initializable {

    @FXML public Button accessSelectedCategoryBtn;
    @FXML public ListView categoryList;
    @FXML public Label userLabel;

    private ArrayList<Category> categories;
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        userLabel.setText("User: " + user.getName());
    }



    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) { this.categories = categories; }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void accessSelectedCategory(ActionEvent actionEvent) {
    }
}
