package access_modifiers;

import inheritance.User;

public class UserInherited extends User {
    public UserInherited(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String getProtectedField() {
        return super.getProtectedField();
    }


}
