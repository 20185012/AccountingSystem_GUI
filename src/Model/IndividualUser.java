package Model;

public class IndividualUser extends User{
    String surname;
    UserType userType;

    public IndividualUser(String name, String surname, String email, String phone, String loginName, String loginPassword, UserType userType) {
        super(name, email, phone, loginName, loginPassword, userType);
        this.surname = surname;
    }


    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getCompanyCode() {
        return null;
    }

    @Override
    public String getAddress() {
        return null;
    }



    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public void setCompanyCode(String companyCode) {
    }

    @Override
    public void setAddress(String address) {
    }


    public String UserDetails() {
        return "IndividualUser{" +
                "surname='" + surname + '\'' +
                ", userType='" + userType + '\'' +
                ", userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                '}';
    }
}
