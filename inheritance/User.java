package inheritance;

public class User extends Entity {
    private String firstName;
    private String lastName;
    public String className=this.getClass().getName();
    public static String staticClass=User.class.getName();
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public String getClassName() {
        return className;
    }

/**
 *     @Override can't be orverride static method
 *     method hiding will happen
  */
    public static String getStaticClass() {
        return staticClass;
    }
}
