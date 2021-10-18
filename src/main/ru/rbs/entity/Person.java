package main.ru.rbs.entity;

import main.ru.rbs.exception.InvalidParamException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static main.ru.rbs.config.ApplicationSettings.DATE_PATTERN;

public class Person {

    private final static SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
    private String name;
    private int age;
    private List<Person> children = new ArrayList<>();
    private Passport passport;

    public static class Passport {
        private String series;
        private String number;
        private Date issuedDate;
        private String address;

        public String getSeries() {
            return series;
        }

        public Passport setSeries(String series) {
            this.series = series;
            return this;
        }

        public String getNumber() {
            return number;
        }

        public Passport setNumber(String number) {
            this.number = number;
            return this;
        }

        public Date getIssuedDate() {
            return issuedDate;
        }

        public Passport setIssuedDate(Date issuedDate) {
            this.issuedDate = issuedDate;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public Passport setAddress(String address) {
            this.address = address;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Passport)) return false;
            Passport passport = (Passport) o;
            return series.equals(passport.series) && number.equals(passport.number) && issuedDate.equals(passport.issuedDate) && address.equals(passport.address);
        }

        @Override
        public int hashCode() {
            return Objects.hash(series, number, issuedDate, address);
        }

        @Override
        public String toString() {
            return "Passport{" +
                    "series='" + series + '\'' +
                    ", number='" + number + '\'' +
                    ", issuedDate=" + dateFormat.format(issuedDate) +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        if (age < 0 || age > 120) {
            throw new InvalidParamException("Age of person should be between 0 and 120");
        }
        this.age = age;
        return this;
    }

    public List<Person> getChildren() {
        return children;
    }

    public Person setChildren(List<Person> children) {
        this.children = children;
        return this;
    }

    public Passport getPassport() {
        return passport;
    }

    public Person setPassport(Passport passport) {
        this.passport = passport;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && Objects.equals(children, person.children) && passport.equals(person.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, children, passport);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", children=" + children +
                ", passport=" + passport +
                '}';
    }
}
