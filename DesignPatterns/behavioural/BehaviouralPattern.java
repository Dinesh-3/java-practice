package DesignPatterns.behavioural;

import DesignPatterns.behavioural.chainOfResponsibility.*;
import DesignPatterns.behavioural.command.*;
import DesignPatterns.behavioural.command.editor.BoldCommand;
import DesignPatterns.behavioural.command.editor.HtmlDocument;
import DesignPatterns.behavioural.command.editor.UndoCommand;
import DesignPatterns.behavioural.command.fx.Button;
import DesignPatterns.behavioural.command.fx.Command;
import DesignPatterns.behavioural.iterator.BrowseHistory;
import DesignPatterns.behavioural.iterator.Iterator;
import DesignPatterns.behavioural.mediator.ArticlesDialogBox;
import DesignPatterns.behavioural.memento.Editor;
import DesignPatterns.behavioural.memento.History;
import DesignPatterns.behavioural.observer.Chart;
import DesignPatterns.behavioural.observer.DataSource;
import DesignPatterns.behavioural.observer.SpreadSheet;
import DesignPatterns.behavioural.state.BrushTool;
import DesignPatterns.behavioural.state.Canvas;
import DesignPatterns.behavioural.state.SelectionTool;
import DesignPatterns.behavioural.strategy.BlackAndWhiteFilter;
import DesignPatterns.behavioural.strategy.ImageStorage;
import DesignPatterns.behavioural.strategy.PngCompressor;
import DesignPatterns.behavioural.template.AuditTrail;
import DesignPatterns.behavioural.template.GenerateReportTask;
import DesignPatterns.behavioural.template.Task;
import DesignPatterns.behavioural.template.TransferMoneyTask;

public class BehaviouralPattern {
    public static void main(String[] args) {
        /**
         * Momento Pattern
         *
         * To restore the state of an object to its previous state
         *
         * Application:
         *  1. It preserves encapsulation boundaries.
         *  2. It simplifies the originator.
         *
         * Used When:
         *  1. It is used in Undo and Redo operations in most software.
         *  2. It is also used in database transactions.
         */
        System.out.println("\n*** Momento Pattern ***\n");
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("1");
        history.push(editor.createState());

        editor.setContent("2");
        history.push(editor.createState());

        editor.setContent("3");
        history.push(editor.createState());

        editor.setContent("4");
        history.push(editor.createState());

        editor.restore(history.pop());
        editor.restore(history.pop());

        System.out.println(editor.getContent());
        System.out.println("\n*** END ***\n");

        /**
         * State Pattern -> Polymorphism and setter implementation contains one has a relation
         *  the class behavior changes based on its state
         * Application:
         *  1. It keeps the state-specific behavior.
         *  2. It makes any state transitions explicit.
         *
         * Used When:
         *  1. When the behavior of object depends on its state, and
         *      it must be able to change its behavior at runtime according to the new state.
         *  2. It is used when the operations have large, multipart conditional statements
         *      that depend on the state of an object.
         */
        System.out.println("\n*** State Pattern ***\n");
        Canvas canvas = new Canvas();
        canvas.setCurrentTool(new BrushTool());

        canvas.mouseDown();
        canvas.mouseUp();

        canvas.setCurrentTool(new SelectionTool());

        canvas.mouseDown();
        canvas.mouseUp();

        /**
         * Iterator Pattern -> Iterating an array of Object's
         *  To access the elements of an aggregate object sequentially without exposing its underlying implementation
         * Application:
         *  1. It supports variations in the traversal of a collection.
         *  2. It simplifies the interface to the collection.
         * Used When:
         *  1. When you want to access a collection of objects without exposing its internal representation.
         *  2. When there are multiple traversals of objects need to be supported in the collection.
         */

        BrowseHistory browseHistory = new BrowseHistory();
        browseHistory.push("https://www.dinesh.com");
        browseHistory.push("https://www.babu.com");
        browseHistory.push("https://www.ranjith.com");

        Iterator historyIterator = browseHistory.createIterator();
//        new BrowseHistory.ArrayIterator(browseHistory);
        while (historyIterator.hasNext()) {
            String url = historyIterator.current();
            System.out.println("url = " + url);
            historyIterator.next();
        }

        /**
         * Strategy Pattern -> Contains one or more has a relation. Polymorphism
         *  defines a family of functionality, encapsulate each one, and make them interchangeable
         * Application:
         *  1. It provides a substitute to subclassing.
         *  2. It defines each behavior within its own class, eliminating the need for conditional statements.
         *  3. It makes it easier to extend and incorporate new behavior without changing the application.
         * Used When:
         * 1. When the multiple classes differ only in their behaviors.e.g. Servlet API.
         * 2. It is used when you need different variations of an algorithm.
         */
        System.out.println("\n*** Strategy Pattern ***");
        ImageStorage imageStorage = new ImageStorage();
        imageStorage.store("dog.png", new PngCompressor(), new BlackAndWhiteFilter());

        /**
         * Template Pattern-> Inheritance
         * just define the skeleton of a function in an operation, deferring some steps to its subclasses
         * Application:
         *  1. It is very common technique for reusing the code.This is only the main benefit of it.
         * Used When:
         *  1. It is used when the common behavior among sub-classes should be moved to a single common class by avoiding the duplication.
         */
        System.out.println("\n*** Template Pattern ***");

        Task transferMoneyTask = new TransferMoneyTask();
        transferMoneyTask.execute();

        GenerateReportTask generateReportTask = new GenerateReportTask(new AuditTrail());
        generateReportTask.execute();

        /**
         * Command Pattern -> Used in frameworks and libraries
         * Also Known as Action or Transaction.
         * encapsulate a request under an object as a command and pass it to invoker object.
         * Invoker object looks for the appropriate object which can handle this command and
         * pass the command to the corresponding object and that object executes the command
         * Application
         *  1. It separates the object that invokes the operation from the object that actually performs the operation.
         *  2. It makes easy to add new commands, because existing classes remain unchanged.
         * Used When:
         *  1. When you need parameterize objects according to an action perform.
         *  2. When you need to create and execute requests at different times.
         *  3. When you need to support rollback, logging or transaction functionality.
         */
        System.out.println("\n*** Command Pattern ***");
        // NOTE : Same interface in different package not work example
        // Type : DesignPatterns.behavioural.command.fx.Command and instantiation implements DesignPatterns.behavioural.command.editor.Command
        //        This will throw compile time Error
        final Command addCustomerCommand = new AddCustomerCommand(new CustomerService());
        Button button = new Button(addCustomerCommand);
        button.click();

        CompositeCommand compositeCommand = new CompositeCommand();
        compositeCommand.add(new BlackAndWhiteCommand());
        compositeCommand.add(new ResizeCommand());
        compositeCommand.execute(); // replay's all added commands

        DesignPatterns.behavioural.command.editor.History history1 = new DesignPatterns.behavioural.command.editor.History();
        HtmlDocument htmlDocument = new HtmlDocument();
        htmlDocument.setContent("Hello World!");
        BoldCommand boldCommand = new BoldCommand(htmlDocument, history1);
        boldCommand.execute();
        System.out.println(htmlDocument.getContent());
        UndoCommand undoCommand = new UndoCommand(history1);
        undoCommand.execute();
        System.out.println(htmlDocument.getContent());

        /**
         * Observer Pattern
         * Types:
         *  1. Push style Communication-> void update(T value); in Observer interface we need to pass the value to got notified.
         *      With this approach there is no coupling between Observers and Subject (or) Observable
         *  2. Pull Style -> In this approach Observers have composition relationship with the subject (dataSource).
         *      With this approach Observers are coupled with dataSource. Below code is example of Pull style communication
         * just define a one-to-one dependency so that when one object changes state,
         * all its dependents are notified and updated automatically
         *
         * Application:
         *  1. It describes the coupling between the objects and the observer.
         *  2. It provides the support for broadcast-type communication.
         *
         * Used When:
         *  1. When the change of a state in one object must be reflected in another object without keeping the objects tight coupled.
         *  2. When the framework we write and needs to be enhanced in future with new observers with minimal changes.
         */
        System.out.println("\n*** Observer Pattern ***");
        DataSource dataSource = new DataSource();
        SpreadSheet spreadSheet = new SpreadSheet(dataSource);
        Chart chart = new Chart(dataSource);
        dataSource.addObserver(spreadSheet);
        dataSource.addObserver(chart);

        dataSource.setValue(3);

        /**
         * Mediator Pattern
         * to define an object that encapsulates how a set of objects interact
         * Application: Lots of benefit
         *  1. It decouples the number of classes.
         *  2. It simplifies object protocols.
         *  3. It centralizes the control.
         *  4. The individual components become simpler and much easier to deal with
         *      because they don't need to pass messages to one another.
         *  5. The components don't need to contain logic to deal with their intercommunication
         *      and therefore, they are more generic.
         * Used When:
         *  1. It is commonly used in message-based systems likewise chat applications.
         *  2. When the set of objects communicate in complex but in well-defined ways.
         */
        System.out.println("\n*** Mediator Pattern ***");
        ArticlesDialogBox dialogBox = new ArticlesDialogBox();
        dialogBox.simulateUserInteraction();

        /**
         * Chain of Responsibility
         * avoid coupling the sender of a request to its receiver by giving multiple objects a chance to handle the request
         * Application:
         *  1. It reduces the coupling.
         *  2. It adds flexibility while assigning the responsibilities to objects.
         *  3. It allows a set of classes to act as one; events produced in one class can be sent to other handler classes
         *      with the help of composition.
         * Used When:
         *  1. When more than one object can handle a request and the handler is unknown.
         *  2. When the group of objects that can handle the request must be specified in dynamic way.
         */
        System.out.println("\n*** Chain of Responsibility ***");
        Compressor compressor = new Compressor(null);
        Logger logger = new Logger(compressor);
        Authenticator authenticator = new Authenticator(logger);

        WebServer webServer = new WebServer(authenticator);
        webServer.handle(new HttpRequest("admin", "1234"));

    }
}
