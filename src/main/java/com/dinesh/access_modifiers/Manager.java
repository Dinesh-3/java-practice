package com.dinesh.access_modifiers;

import com.dinesh.inheritance.Entity;

public class Manager extends Entity {
    @Override
    public String getProtectedField() { // we can override protected fields. But default modifier can't be overridden
        return super.getProtectedField(); // At compile time it will show the Manager even though we call super, because we're assigning this result getClass().getName()
    }

}
