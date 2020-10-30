package Utils;

import Model.Category;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionModel;

import javax.swing.text.html.ListView;
import java.util.ArrayList;

public class CategoryUtils {
    public static Category accessLastCategory(ArrayList<Category> categories) {
        return categories.get(categories.size()-1);
    }

    public static Category getSelectedCategory(Object selectedItem, ArrayList<Category> categories) {

        if (selectedItem != null)
        {
            String[] categoryData = selectedItem.toString().split(": ");

            Category selectedCategory = categories.stream().filter(category -> category.getCategoryID().equals(categoryData[0])).findFirst().orElse(null);

            return selectedCategory;
        }
        return null;
    }

    public static void populateCategoryList(ObservableList observableList, ArrayList <Category> categories)
    {
        categories.forEach(category -> observableList.add(category.getCategoryID() + ": " + category.getCategoryName()));
    }
}
