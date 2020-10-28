package Model;



import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class SystemRoot implements Serializable{
    private final String companyName;
    private final LocalDateTime systemInitialDate;
    private final ArrayList<Category> rootCategories;
    private final ArrayList<User> users;
    //ArrayList<User> currentUsers;


    public SystemRoot(String companyName)
    {
        this.companyName = companyName;
        this.systemInitialDate = LocalDateTime.now();
        rootCategories = new ArrayList<Category>();
        users = new ArrayList<User>();
    }


    public ArrayList<User> getAllUsers() {
        return users;
    }

    public ArrayList<Category> getRootCategories() {
        return rootCategories;
    }

    public LocalDateTime getSystemInitialDate() {
        return systemInitialDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDetails() {
        StringBuilder systemInfo = new StringBuilder (this.companyName + "\nSystem created: "
                                                     + this.systemInitialDate + "\nSystem creator: "
                                                     + this.users.get(0).loginName + "\nRoot categories: ");

        for (Category category : rootCategories)
        {
            systemInfo.append(category.getCategoryName() + " ");
        }

        return systemInfo.toString();
    }
}
