public class Console {
    /*
      Variable Argument (Varargs):
    The varargs allows the method to accept zero or multiple arguments.
    Before varargs either we use overloaded method
    or take an array as the method parameter,
    but it was not considered good because it leads to the maintenance problem.
    If we don't know how many argument we will have to pass in the method,
    varargs is the better approach.

    Compile Time Error:
        1. (T... args, String name) -> Varargs must be last in list
        2. (String... names, T... args) -> Multiple Varargs not allowed
     */
    public static <T> void log(T... args) {
        for (int i = 0; i < args.length - 1; i++) {
            System.out.print(args[i] + " ");
        }
        System.out.println(args[args.length-1]);
//        for(var item: args) {
//            System.out.print(item + " ");
//        }
//        System.out.println();
    }
}
