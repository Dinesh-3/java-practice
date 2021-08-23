public class Console {

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
