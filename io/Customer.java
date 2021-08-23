package io;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer extends IOPractise implements Serializable {
    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private byte age;
    private LocalDate date;
    private int id;

    public Customer(String firstName, String lastName, String gender, String country, byte age, LocalDate date, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.age = age;
        this.date = date;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public byte getAge() {
        return age;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                firstName + ',' +
                        lastName + ',' +
                        gender + ',' +
                        country + ',' +
                        age + ',' +
                        date + ',' +
                        id
                ;
    }

}
