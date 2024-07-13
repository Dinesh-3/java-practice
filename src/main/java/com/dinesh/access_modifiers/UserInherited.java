package com.dinesh.access_modifiers;

import com.dinesh.inheritance.User;

public class UserInherited extends User {
    public UserInherited(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String getProtectedField() {
        return super.getProtectedField();
    }


}
