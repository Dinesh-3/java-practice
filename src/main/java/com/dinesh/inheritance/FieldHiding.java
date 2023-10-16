package inheritance;

class Father {
    public String name = "Father";
    public int age = 50;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Son extends Father {
    public String name = "Son";
    public int age = 20;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

}

public class FieldHiding {
    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        System.out.println("father.name = " + father.name);
        System.out.println("father.getName() = " + father.getName());

        System.out.println("son.name = " + son.name); // Father
        System.out.println("son.getName() = " + son.getName()); // Son
    }
}
