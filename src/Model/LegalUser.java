package Model;

public class LegalUser extends User {

    String address;
    String companyCode;
    String userType = "LegalUser";

    public LegalUser(String name, String address, String email, String phone, String companyCode, String loginName, String loginPassword) {
        super(name, email, phone, loginName, loginPassword);
        this.address = address;
        this.companyCode = companyCode;
    }

    @Override
    public String UserDetails() {
        return "LegalUser{" +
                "address='" + address + '\'' +
                ", companyCode='" + companyCode + '\'' +
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
