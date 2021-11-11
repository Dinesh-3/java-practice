package Interfaces;

import java.lang.reflect.Method;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String interfaceName = Utility2.getInterfaceName();
        System.out.println("interfaceName = " + interfaceName);
        int ram = Laptop.getRam();
        System.out.println("ram = " + ram);

        HP hp = new HP(20_000);
        int size = hp.getHash();

        HP hp1 = new HP(20_000);
        int size1 = hp1.getHash();

        System.out.println("size = " + size);
        System.out.println("size1 = " + size1);

//        String interfaceName = CombinedUtility.interfaceName; // through error because util1, util2 has same fieldName
        Utility utility = new Utility();

    }
}
