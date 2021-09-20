package tricky;

public class StringPractise {
    public static void main(String[] args) {
        mutableString();
        String name1 = "name1";
        String name2 = "name2";
        String name3 = "name1";
        String name4 = new String("name2");
        String name5 = new String("name2");

        String newName1 = "newName1";
        String newName2 = "newName2";

//        System.out.println(name1 == name1);
//        System.out.println(name1 == name2);
//        System.out.println(name1.equals(name1));
//        System.out.println(name1.equals(name3));
//        System.out.println(name2.equals(name4));

        ImmutableUser dinesh = new ImmutableUser("Dinesh", "I");

        ImmutableUser copiedUser = dinesh;
        ImmutableUser babu = copiedUser.setFirstName("Babu");
        System.out.println("babu.getFirstName() = " + babu.getFirstName());
        System.out.println(dinesh == babu);

    }

    protected static void mutableString() {
        char c = 'c';
        char c1 = 'c';
        if(c == c1) System.out.println("c = c1");
        /*
                StringBuffer
            Points:
                1. Thread safe
                2. legacy class introduced 1.0
                3. Low performance
         */
        StringBuffer dinesh = new StringBuffer("Dinesh");
        dinesh.append(" I");
        System.out.println("dinesh = " + dinesh);

         /*
                StringBuffer
            Points:
                1. Not Thread safe
                2. Introduced in 1.5
                3. High performance
         */
        StringBuilder babu = new StringBuilder("Babu");
        babu.append(" K");
        System.out.println("babu = " + babu);

        SpeedTestBuffervsBuilder();
    }

    private static void SpeedTestBuffervsBuilder() {
        long startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer("Java");
        for (int i=0; i<10_000; i++){
            sb.append("Tpoint");
        }
        System.out.println("Time taken by StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder("Java");
        for (int i=0; i<1_0_0_0_0; i++){
            sb2.append("Tpoint");
        }
        System.out.println("Time taken by StringBuilder: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}


