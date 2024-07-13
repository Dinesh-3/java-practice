package com.dinesh.tricky;

public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        System.out.println("Loading class: " + name);
        return super.loadClass(name, resolve);
    }

    public static void main(String[] args) {
        try {
            CustomClassLoader loader = new CustomClassLoader();
            Class<?> cls = loader.loadClass("java.lang.String");
            System.out.println("Class loaded: " + cls.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
