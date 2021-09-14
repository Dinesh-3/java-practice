package pattern;

public class Teacher extends AbstractProfession implements Profession {
    @Override
    public String profession() {
        return "teacher";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
