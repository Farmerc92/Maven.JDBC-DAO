package models;

public class DTO implements DTOCard{
    private String type;
    private String firstName;
    private String lastName;
    private String cardNumber;
    private String ssn;

    public DTO() {
    }

    public DTO(String type, String firstName, String lastName, String cardNumber, String ssn) {
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNumber = cardNumber;
        this.ssn = ssn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSSN() {
        return ssn;
    }
}
