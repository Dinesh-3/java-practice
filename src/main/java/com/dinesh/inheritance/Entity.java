package com.dinesh.inheritance;

public class Entity {
    public static int index;
    protected boolean isEnabled;
    public String className= getClass().getName();
    public static String staticClass=Entity.class.getName();
    protected String protectedField = "Protected Field";
    String defaultField = "Default Field";
    private String developer = "Dinesh";
    public Entity() {

        index++;
    }
    public int getId(){ // If we define this also getIndex() will throw error static and instance method names are not to be same
//        index++;
        int index1 = index;
        int index = getIndex();
        System.out.println("index = " + index);
        return Entity.getIndex();
    }

    public static int getIndex() {
        return index;
    }

    @Override
    public void finalize() throws Throwable { // We change access modifier to high level of visibility
        /**
         * private void finalize() throws Throwable { // Throws error
         * More Restriction is not allowed if parent class is public
         * we can't change to private or protected
         * If parent is protected we change to public in subclass
         *
         * Note: We make more accessible, but we can't make as less accessible
         */
        System.out.println("Garbage Collector called");
        super.finalize();
    }

    public String getClassName() {
        return className;
    }

    public static String getStaticClass() {
        return staticClass;
    }

    protected String getProtectedField() {
        return String.format("%s in %s", protectedField, className);
    }

    String getDefaultField() {
        return defaultField;
    }

    protected String getEntityName() {
        return "ENTITY";
    }

}
