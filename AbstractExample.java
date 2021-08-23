abstract class AbstractExample {
    private String name = "";

    public AbstractExample(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    abstract void getNewName();
}
