package Interfaces;

public interface CombinedUtility extends Utility1, Utility2{

//    String interfaceName = CombinedUtility.class.getSimpleName();

    @Override
    default void print(int a) {
        Utility1.super.print(a);
    }

    @Override
    default int getName() {
        return 0;
    }
}
