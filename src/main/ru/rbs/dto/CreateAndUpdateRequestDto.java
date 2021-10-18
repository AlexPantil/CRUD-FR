package main.ru.rbs.dto;

import java.util.Date;

public class CreateAndUpdateRequestDto {
    private String personName;
    private int personAge;
    private String childrenNames;
    private String passportSeries;
    private String passportNumber;
    private Date passportIssuedDate;
    private String passportAdress;

    public String getPersonName() {
        return personName;
    }

    public CreateAndUpdateRequestDto setPersonName(String personName) {
        this.personName = personName;
        return this;
    }

    public int getPersonAge() {
        return personAge;
    }

    public CreateAndUpdateRequestDto setPersonAge(int personAge) {
        this.personAge = personAge;
        return this;
    }

    public String getChildrenNames() {
        return childrenNames;
    }

    public CreateAndUpdateRequestDto setChildrenNames(String childrenNames) {
        this.childrenNames = childrenNames;
        return this;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public CreateAndUpdateRequestDto setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
        return this;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public CreateAndUpdateRequestDto setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
        return this;
    }

    public Date getPassportIssuedDate() {
        return passportIssuedDate;
    }

    public CreateAndUpdateRequestDto setPassportIssuedDate(Date passportIssuedDate) {
        this.passportIssuedDate = passportIssuedDate;
        return this;
    }

    public String getPassportAdress() {
        return passportAdress;
    }

    public CreateAndUpdateRequestDto setPassportAdress(String passportAdress) {
        this.passportAdress = passportAdress;
        return this;
    }
}
