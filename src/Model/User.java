package Model;


import java.io.Serializable;

public abstract class User implements Serializable {

    private static int userIDGenerator = 0;

    protected String userID;
    protected String name;
    protected String email;
    protected String phone;
    protected String loginName;
    protected String loginPassword;
    //ArrayList<Category> categoriesResponsible;
    boolean active;

    public User(String name, String email, String phone, String loginName, String loginPassword) {
        this.userID = Integer.toString(userIDGenerator++);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public String getUserID() { return userID; }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public String getPhone() { return phone; }

    public void setUserID(int userId) { this.userID = Integer.toString(userId); }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public abstract String UserDetails();
}
