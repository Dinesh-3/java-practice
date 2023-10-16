package io;

import java.io.*;
import java.time.LocalDate;
import java.util.UUID;


public class Customer extends Main implements Serializable
        , Externalizable
{
//    @Serial
    private static final long serialVersionUID = -5623412787116685771L;
    private String firstName;
    private String lastName;
    private String gender;
    /**
     * This Field Is Not Stored while serialization value will be null while deserialization
     * If we implement Externalizable keyword not take any effect or work
     */
    private transient  String country = "IN";
    private byte age;
    private LocalDate date;
    private int id;

    public Customer() { // No args constructor is required for serialization
    }

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
        return "{" +
                firstName + ',' +
                        lastName + ',' +
                        gender + ',' +
                        country + ',' +
                        age + ',' +
                        date + ',' +
                        id + "}"
                ;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("writeExternal = " + out);
        out.writeObject(firstName);
        out.writeObject(lastName);
        out.writeObject(country);
        out.writeByte(age);
        out.writeObject(date);
        out.writeInt(id);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("readExternal = " + in);
        firstName = (String) in.readObject();
        lastName = (String) in.readObject();
        country = (String) in.readObject();
        age = in.readByte();
        date = (LocalDate) in.readObject();
        id = in.readInt();
    }
}
