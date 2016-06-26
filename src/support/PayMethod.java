package support;

import usr.User;

import java.io.Serializable;

/**
 * Created by mac on 16/6/26.
 */
public class PayMethod implements Serializable{
    private String bankNumber;
    private String fristName;
    private String lastName;
    private int validMonth;
    private int validYear;
    private String cVV;
    private Address billAddress;
    private User owner;

    public PayMethod(String bankNumber, String fristName, String lastName, int validMonth, int validYear, String cVV, Address billAddress, User owner) {
        this.bankNumber = bankNumber;
        this.fristName = fristName;
        this.lastName = lastName;
        this.validMonth = validMonth;
        this.validYear = validYear;
        this.cVV = cVV;
        this.billAddress = billAddress;
        this.owner = owner;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getValidMonth() {
        return validMonth;
    }

    public void setValidMonth(int validMonth) {
        this.validMonth = validMonth;
    }

    public int getValidYear() {
        return validYear;
    }

    public void setValidYear(int validYear) {
        this.validYear = validYear;
    }

    public String getcVV() {
        return cVV;
    }

    public void setcVV(String cVV) {
        this.cVV = cVV;
    }

    public Address getBillAddress() {
        return billAddress;
    }

    public void setBillAddress(Address billAddress) {
        this.billAddress = billAddress;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PayMethod)) return false;

        PayMethod payMethod = (PayMethod) o;

        if (validMonth != payMethod.validMonth) return false;
        if (validYear != payMethod.validYear) return false;
        if (!bankNumber.equals(payMethod.bankNumber)) return false;
        if (!fristName.equals(payMethod.fristName)) return false;
        if (!lastName.equals(payMethod.lastName)) return false;
        if (!cVV.equals(payMethod.cVV)) return false;
        if (!billAddress.equals(payMethod.billAddress)) return false;
        return owner.equals(payMethod.owner);

    }

    @Override
    public String toString() {
        return bankNumber + ','
                + fristName + ","
                + lastName + ","
                + validMonth + ","
                + validYear + ","
                + cVV + ","
                + billAddress + ","
                + owner;
    }
}
