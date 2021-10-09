public class UserExample extends AbstractExample {

    public UserExample(String text) {
        super(text);
    }

    @Override
    String getNewName() {
        System.out.println("getName() = " + getName());
        return getName();
    }
}
