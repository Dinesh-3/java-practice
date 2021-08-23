public class Utils {
    public static void printUser(GenericList<? extends User> users) {
        Manager manager = new Manager("Dinesh", "I", (byte) 20);
        User user = new User("User", "I", (byte) 20);
        User user1 = users.get(0);
        System.out.println("user1.getFirstName() = " + user1.getFirstName());
    }

    public static void addUser(GenericList<? super User> users) {
        Manager manager = new Manager("Dinesh", "I", (byte) 20);
        User user = new User("User", "I", (byte) 20);
        users.add(manager);
        users.add(user);
    }
}
