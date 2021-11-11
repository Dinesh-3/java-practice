import exception.UserException;

import java.util.Objects;

public class User implements DetailInterface{

    private String firstName;
    private String lastName;
    private byte age;

    public User(String firstName, String lastName, byte age) throws UserException {
        this.firstName = firstName;
        this.lastName = lastName;
        setAge(age);
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

    public void setAge(byte age) throws UserException {
        if(age < 1) throw new UserException("Invalid User", new InvalidAgeException("Age should not be zero or negative"));
        this.age = age;
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
        return "User{" +
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
}
