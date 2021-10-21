package access_modifiers;

import inheritance.User;

public class UserInherited extends User {
    public UserInherited(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    protected String getProtectedField() {
        return super.getProtectedField();
    }
}
