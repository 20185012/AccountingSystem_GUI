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
    protected UserType userType;

    public User(String name, String email, String phone, String loginName, String loginPassword, UserType userType) {
        this.userID = Integer.toString(userIDGenerator++);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.userType = userType;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public String getUserID() { return userID; }

    public String getName() { return name; }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() { return email; }

    public String getPhone() { return phone; }

    public void setUserID(int userId) { this.userID = Integer.toString(userId); }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public UserType getUserType() {
        return userType;
    }




    public abstract String getSurname();

    public abstract String getCompanyCode();

    public abstract String getAddress();

    public abstract void setSurname(String surname);

    public abstract void setCompanyCode(String companyCode);

    public abstract void setAddress(String address);

    public abstract String UserDetails();
}
