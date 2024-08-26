package com.dinesh.inheritance;

public class User extends Entity {
    private String firstName;
    private String lastName;
    public String className=this.getClass().getName();
    public String field = "User Field";
//    @Override // Fields are can't be override
//    public String className = this.getClass().getName();
//    private static String staticClass=model.User.class.getName();
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
        return "model.User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public String getClassName() {
        System.out.println("super.isEnabled = " + super.isEnabled);
        return className;
    }

/**
 *     @Override can't be orverride static method
 *     method hiding will happen
  */
    public static String getStaticClass() {
        return staticClass;
    }

    @Override
    protected String getProtectedField() {
        return super.getProtectedField();
    }

    @Override
    String getDefaultField() {
        return super.getDefaultField();
    }
}
