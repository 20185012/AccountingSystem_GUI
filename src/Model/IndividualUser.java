package Model;

public class IndividualUser extends User{
    String surname;
    String userType = "IndividualUser";

    public IndividualUser(String name, String surname, String email, String phone, String loginName, String loginPassword) {
        super(name, email, phone, loginName, loginPassword);
        this.surname = surname;

        active = true;
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
