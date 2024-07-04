package tricky;


import object.Dog;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

public class SystemPractise {
    public static void main(String[] args) throws IOException {

//        Process shCommand = Runtime.getRuntime().exec("dir");
//
//        byte[] bytes = shCommand.getInputStream().readAllBytes();
//        char[] chars = new char[bytes.length];
//        for (int i = 0; i < bytes.length; i++) {
//            chars[i] = (char) bytes[i];
//        }
//        String commandResult = String.valueOf(chars);

//        String commandResult = new String(bytes, StandardCharsets.UTF_8);
//        System.out.println("commandResult : \n" + commandResult);

        Map<String, String> env = System.getenv();
        env.forEach((a, b) -> System.out.println( a + " = " + b));

        String pwd = env.get("PWD");
        System.out.println("pwd = " + pwd);

        for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
//            entry.setValue("New"); // danger
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

//        String put = env.put("unique_key", "sample_value"); // throws UnsupportedOperationException
//        System.out.println("put env = " + put);

        /**
         * The java.lang.Runtime.loadLibrary(String filename)
         * method loads the dynamic library with the specified library name.
         * A file containing native code is loaded from
         * the local file system from a place where library files are
         * conventionally obtained. The details of this process are implementation-dependent.
         * The mapping from a library name to a specific filename is done
         * in a system-specific manner.
         */

//        System.loadLibrary(""); // To load native at dynamically
        var puppy =  new Dog("Puppy");
        var twinky =  new Dog("Twinky");

        System.out.println(puppy);
        System.out.println(twinky);

        /**
         * The difference between System.gc and System.runFinalization
         * System.gc();
         * //Tell the garbage collector that it intends to perform garbage collection,
         * and it is uncertain whether the garbage collector will collect
         *
         * System.runFinalization();
         * //Force the finalize method of the object that has lost the reference
         *
         * System.gc(); hints the VM that it is probably time to activate
         * the Thread doing to the Garbage Collection. So all the part of this sentence stands in the hint word.
         * The finalizer are run according to the VM good will, generally speaking.
         * This means they could be run or could not. Invoking the System.runFinalization( );
         * force the VM to invoke on each instance the finalizer when it Garbage collects the Object referenced
         */
        System.runFinalization(); // Runtime.getRuntime().runFinalization()

    }
}

