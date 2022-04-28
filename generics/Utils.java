package generics;

import model.Manager;
import model.User;
import utils.GenericList;

import java.util.List;

public class Utils {
    public static void printUser(GenericList<? extends User> users) {
        Manager manager = new Manager("Dinesh", "I", (byte) 20);
        User user = new User("model.User", "I", "2003-08-01");
        User user1 = users.get(0); // using extends we can view
//        users.add(user); // throw error
        System.out.println("user1.getFirstName() = " + user1.getFirstName());
    }

    public static void addUser(List<? super User> users) {
        Manager manager = new Manager("Dinesh", "I", (byte) 20);
        User user = new User("model.User", "I", "2003-06-01");
        users.add(manager); // using super we can add
        users.add(user);
        User object = (User) users.get(0);

        System.out.println("object = " + object);
    }
}
