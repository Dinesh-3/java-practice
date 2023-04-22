package inheritance.sub_package;

public class SubClass {
    protected String protectedField = "Protected Field";
    String defaultField = "Default Field";

    protected String getProtectedField() {
        return protectedField;
    }

    String getDefaultField() {
        return defaultField;
    }
}
