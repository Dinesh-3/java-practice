package tricky;

public class StringPractise {
    public static void main(String[] args) {
        String name1 = "name1";
        String name2 = "name2";
        String name3 = "name1";

        String newName1 = "newName1";
        String newName2 = "newName2";

        System.out.println(name1 == name1);
        System.out.println(name1 == name2);
        System.out.println(name1.equals(name1));
        System.out.println(name1.equals(name3));

        ImmutableUser dinesh = new ImmutableUser("Dinesh", "I");

        ImmutableUser copiedUser = dinesh;
        ImmutableUser babu = copiedUser.setFirstName("Babu");
        System.out.println("babu.getFirstName() = " + babu.getFirstName());
        System.out.println(dinesh == babu);

    }
}


