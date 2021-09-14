package pattern;

public class Engineer extends AbstractProfession implements Profession{
    @Override
    public String profession() {
        return "engineer";
    }
}
