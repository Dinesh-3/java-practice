package access_modifiers;

import inheritance.Entity;

public class Manager extends Entity {
    @Override
    public String getProtectedField() { // we can override protected fields. But defaults can't be override
        return super.getProtectedField(); // At compile time it will show the Manager even though we call super
    }

}
