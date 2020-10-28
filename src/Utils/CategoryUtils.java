package Utils;

import Model.Category;
import javafx.fxml.FXML;
import javafx.scene.control.MultipleSelectionModel;

import javax.swing.text.html.ListView;
import java.util.ArrayList;

public class CategoryUtils {
    public static int findCategoryIndex(String categoryName, ArrayList<Category> categories)
    {
        for (int i = 0; i < categories.size(); i++)
        {
            if (categories.get(i).getCategoryName().equals(categoryName.toUpperCase()))
            {
                return i;
            }
        }
        return -1;
    }

    public static Category accessLastCategory(ArrayList<Category> categories) {
        return categories.get(categories.size()-1);
    }

    public static Category getSelectedCategory(MultipleSelectionModel multipleSelectionModel, ArrayList<Category> categories) {
        String[] categoryData = multipleSelectionModel.getSelectedItem().toString().split(": ");

        Category selectedCategory = categories.stream().filter(category -> category.getCategoryID().equals(categoryData[0])).findFirst().orElse(null);

        return selectedCategory;
    }
}
