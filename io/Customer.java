package io;

import java.io.*;
import java.time.LocalDate;
import java.util.UUID;


public class Customer extends IOPractise implements Serializable
//        , Externalizable
{
    private String firstName;
    private String lastName;
    private String gender;
    private transient String country = "IN"; // This Field Is Not Stored while serialization value will be null while deserialization
    private byte age;
    private LocalDate date;
    private int id;
    @Serial
    private UUID serialNo = UUID.randomUUID();

    public Customer(String firstName, String lastName, String gender, byte age, LocalDate date, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.date = date;
        this.id = id;
    }

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //    @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//
//    }
}
