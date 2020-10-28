package Utils;

import Model.Category;

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
}
