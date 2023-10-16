package model;

import model.User;

import java.time.LocalDate;

public class Manager extends User {

    public Manager(String firstName, String lastName, byte age) {
        super(firstName, lastName, LocalDate.now().minusYears(age).toString());
    }
}
