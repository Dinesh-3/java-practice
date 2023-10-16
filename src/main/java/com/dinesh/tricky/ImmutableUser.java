package tricky;

final public class ImmutableUser {
    private final String firstName;
    private final String lastName;

    public ImmutableUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ImmutableUser setFirstName(String firstName) {
        return new ImmutableUser(firstName, lastName);
    }

    public ImmutableUser setLastName(String lastName) {
        return new ImmutableUser(firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.clone();
    }
}
