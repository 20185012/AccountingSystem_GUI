package Model;

public class LegalUser extends User {

    String address;
    String companyCode;
    UserType userType;

    public LegalUser(String name, String email, String phone, String loginName, String loginPassword, String address, String companyCode, UserType userType) {
        super(name, email, phone, loginName, loginPassword, userType);
        this.address = address;
        this.companyCode = companyCode;
        this.userType = userType;
    }


    @Override
    public String getSurname() {
        return null;
    }

    @Override
    public String getCompanyCode() {
        return companyCode;
    }

    @Override
    public String getAddress() {
        return address;
    }



    @Override
    public void setSurname(String surname) {

    }



    @Override
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
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
