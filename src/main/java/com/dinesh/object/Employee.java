package com.dinesh.object;

public class Employee {
    private String firstName;
    private String lastName;
    private int rank;

    public Employee(String firstName, String lastName, int rank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rank = rank;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getRank() {
        return rank;
    }
}
