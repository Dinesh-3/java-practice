package design_patterns.structural;

import design_patterns.structural.adapter1.*;
import design_patterns.structural.adapter1.avaFilters.Caramel;
import design_patterns.structural.bridge1.AdvancedRemoteControl;
import design_patterns.structural.bridge1.RemoteControl;
import design_patterns.structural.bridge1.SamsungTV;
import design_patterns.structural.bridge1.SonyTV;
import design_patterns.structural.composite1.Group;
import design_patterns.structural.composite1.Shape;
import design_patterns.structural.decorator1.CloudStream;
import design_patterns.structural.decorator1.CompressedCloudStream;
import design_patterns.structural.decorator1.EncryptedCloudStream;
import design_patterns.structural.decorator1.Stream;
import design_patterns.structural.facade1.NotificationService;
import design_patterns.structural.flyweight1.Point;
import design_patterns.structural.flyweight1.PointIconFactory;
import design_patterns.structural.flyweight1.PointService;
import design_patterns.structural.proxy1.EbookProxy;
import design_patterns.structural.proxy1.Library;

/**
 *  Structural design patterns are concerned with how classes and objects can be composed, to form larger structures.
 *  The structural design patterns simplifies the structure by identifying the relationships.
 *  These patterns focus on, how the classes inherit from each other and how they are composed of other classes.
 * Types:
 *  1. Adapter Pattern
 *  2. Bridge Pattern
 *  3. Composite Pattern - allow clients to operate in generic manner on objects that may or may not represent a hierarchy of objects
 *  4. Decorator Pattern
 *  5. Facade Pattern
 *  6. Flyweight Pattern
 *  7. Proxy Pattern
 */
public class StructuralPattern {
    public static void main(String[] args) {
        /**
         * Composite Design Pattern
         *  allow clients to operate in generic manner on objects that may or may not represent a hierarchy of objects
         * Application:
         *  1. It defines class hierarchies that contain primitive and complex objects.
         *  2. It makes easier to you to add new kinds of components.
         *  3. It provides flexibility of structure with manageable class or interface.
         * Used When:
         *  1. When you want to represent a full or partial hierarchy of objects.
         *  2. When the responsibilities are needed to be added dynamically to the individual objects without affecting other objects.
         *     Where the responsibility of object may vary from time to time.
         */
        System.out.println("\n*** Composite Pattern ***\n");

        Shape shape1 = new Shape(1);
        Shape shape2 = new Shape(2);

        Group group1 = new Group();
        group1.add(shape2);
        group1.add(shape1);

        group1.render();

        Shape shape3 = new Shape(3);
        Shape shape4 = new Shape(4);

        /**
         * Adapter Pattern
         *  Converts the interface of a class into another interface that a client wants
         *  Application:
         *      1. It allows two or more previously incompatible objects to interact.
         *      2. It allows reusability of existing functionality.
         *  Used When:
         *      1. When an object needs to utilize an existing class with an incompatible interface.
         *      2. When you want to create a reusable class that
         *          cooperates with classes which don't have compatible interfaces.
         */
        System.out.println("\n*** Adapter Pattern ***\n");

        ImageView imageView = new ImageView(new Image());
        imageView.apply(new VividFilter());
        imageView.apply(new CaramelFilter(new Caramel())); // using third party library with the help of adapter pattern

        /**
         * Decorator Pattern OR Wrapper Pattern
         *  attach a flexible additional responsibilities to an object dynamically
         *  The Decorator Pattern is also known as Wrapper.
         * Application:
         *  1. It provides greater flexibility than static inheritance.
         *  2. It enhances the extensibility of the object, because changes are made by coding new classes.
         *  3. It simplifies the coding by allowing you to develop a series of functionality from
         *      targeted classes instead of coding all the behavior into the object.
         *
         *  Used When:
         *      1. When you want to transparently and dynamically add responsibilities to objects without affecting other objects.
         *      2. When you want to add responsibilities to an object that you may want to change in the future.
         *      3. Extending functionality by sub-classing is no longer practical.
         */
        System.out.println("\n*** Decorator Pattern ***\n");
        Stream stream = new CloudStream();
        Stream encryptedCloudStream = new EncryptedCloudStream(new CompressedCloudStream(stream));
        encryptedCloudStream.write("Dinesh I");

        /**
         * Facade Pattern
         *  just provide a unified and simplified interface to a set of interfaces in a subsystem,
         *  therefore it hides the complexities of the subsystem from the client
         * Application:
         *  1. Removes code duplication
         *  2. Provides simple interface to a complex system
         *  3. It shields the clients from the complexities of the sub-system components.
         *  4. It promotes loose coupling between subsystems and its clients.
         * Used When:
         *  1. When you want to provide simple interface to a complex sub-system.
         *  2. When several dependencies exist between clients and the implementation classes of an abstraction.
         */
        System.out.println("\n*** Facade Pattern ***\n");

        var notificationService = new NotificationService();
        notificationService.send("Hello World!", "mobile"); // send method has all the complexity to send a message

        /**
         * Flyweight Pattern
         * To reuse already existing similar kind of objects by storing them
         * and create new object when no matching object is found
         *
         * Notes:
         *  1. We can use HashMap for storing objects.
         *
         * Application:
         *  1. It reduces the number of objects.
         *  2. It reduces the amount of memory and storage devices required if the objects are persisted
         *
         * Used When:
         *  1. When an application uses number of objects
         *  2. When the storage cost is high because of the quantity of objects.
         *  3. When the application does not depend on object identity.
         */
        System.out.println("\n*** Flyweight Pattern ***\n");

        PointService pointService = new PointService(new PointIconFactory());
        for (Point point : pointService.getPoints()) {
            point.draw();
        }


        /**
         * Bridge Pattern
         * decouple the functional abstraction from the implementation so that the two can vary independently
         * This Pattern also known as Handle or Body
         *
         * Application:
         *  1. It enables the separation of implementation from the interface.
         *  2. It improves the extensibility.
         *  3. It allows the hiding of implementation details from the client.
         *  4. We can easily extend features independent to each other.
         *
         * Used When:
         *  1. When you don't want a permanent binding between the functional abstraction and its implementation.
         *  2. When both the functional abstraction and its implementation need to extended using sub-classes.
         *  3. It is mostly used in those places where changes are made in the implementation does not affect the clients.
         *
         */
        System.out.println("\n*** Bridge Pattern ***\n");
        RemoteControl remote = new RemoteControl(new SonyTV());
        remote.turnOn();

        AdvancedRemoteControl advancedRemote = new AdvancedRemoteControl(new SamsungTV());
        remote.turnOff();

        /**
         * Proxy Pattern
         *  provides the control for accessing the original object
         * Application:
         *  1. hiding the information of original object, on demand loading etc.
         *  2. It provides the protection to the original object from the outside world.
         *  3. Lazy initialization.
         *
         * Types:
         *  1. Virtual Proxy -> Avoids duplicate objects, and lazy loading
         *  2. Protective Proxy -> Acts as an authentication layer
         *  3. Remote Proxy -> For RPC or providing interface for remote resources such as web service or REST resources.
         *  4. Smart Proxy -> -A smart proxy provides additional layer of security by interposing specific actions when the object is accessed
         */
        System.out.println("\n*** Proxy Pattern ***\n");

        String[] books = {"a", "b", "c", "d"};
        Library library = new Library();
        for(var book: books)
            library.add(new EbookProxy(book));

        library.openEbook("b");

    }
}
