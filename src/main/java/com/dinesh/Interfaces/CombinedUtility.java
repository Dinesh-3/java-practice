package com.dinesh.Interfaces;

public interface CombinedUtility extends Utility1, Utility2{

    String interfaceName = CombinedUtility.class.getSimpleName();

    /**
     * Must need to be override if two interface having same method signature && 1 or more default implementation
     * Interfaces.CombinedUtility inherits unrelated defaults for print(int)
     * from types Interfaces.Utility1 and Interfaces.Utility2
     */
    @Override
    default void print(int a) {
        Utility1.super.print(a);
    }

    @Override
    default int getName() {
        return 0;
    }
}
