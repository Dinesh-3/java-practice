package model;

import exception.UserException;
import system.CopyToClipboard;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Objects;

public class User implements DetailInterface {

    private String firstName;
    private String lastName;
    private byte age;
    private LocalDate dateOfBirth;

    public User(String firstName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        setAge();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public byte getAge() {
        return age;
    }

    private void setAge() throws UserException {
        this.age = (byte) Period.between(dateOfBirth ,LocalDate.now()).getYears();
    }

    public void setFirstName(String firstName) {
        if (firstName.length() > 5) {
            this.firstName = firstName;
        }
    }

    @Override
    public String getDob() {
        return "25-07-2017";
    }

    @Override
    public int salary() {
        return 12_000_000;
    }

    @Override
    public String toString() {
        return "model.User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public int compareTo(User other) {
//        int compare = Byte.compare(other.age, this.age); // (second, first) descending order
        int compare = Byte.compare(this.age, other.age); // (second, first) ascending order
//        System.out.println(other.age + " " + this.age);
//        System.out.println("compare = " + compare);
        return compare;
//        return this.age > other.age ? -1 : this.age == other.age ? 0 : 1;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public static void covertAgeIntoDateOfBirthAndCopy(ArrayList<User> users) {
        StringBuilder builder = new StringBuilder();
        for (User user: users) {
            String converted = String.format("new User(\"%s\", \"%s\", \"%s\"),", user.firstName, user.lastName, LocalDate.now().minusYears(user.getAge()));
            builder.append(converted);
        }

        CopyToClipboard.copy(builder.toString());
    }
}
