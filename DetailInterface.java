public interface DetailInterface {
    public static String NAME="Dinesh";
    String getDob();
    int salary();
    default int get(){
        return 1;
    }
    static String getName(){
        return NAME;
    }
}
