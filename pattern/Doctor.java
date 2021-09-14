package pattern;

public class Doctor extends AbstractProfession implements Profession {
    @Override
    public String profession() {
        return "doctor";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
