public class UserExample extends AbstractExample {

    public UserExample(String text) {
        super(text);
    }

    @Override
    void getNewName() {
        System.out.println("getName() = " + getName());
    }
}
