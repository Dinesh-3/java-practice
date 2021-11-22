package tricky;

public class StringPractise {
    public static void main(String[] args) {
        mutableString();
        stringEqualsCheck();

        ImmutableUser dinesh = new ImmutableUser("Dinesh", "I");

        ImmutableUser copiedUser = dinesh;
        ImmutableUser babu = copiedUser.setFirstName("Babu");
        System.out.println("dinesh == copiedUser = " + (dinesh == copiedUser));
        System.out.println("dinesh == babu = " + (dinesh == babu));

    }

    private static void stringEqualsCheck() {
        String dineshWithoutNew = "dinesh";
        String babuWithoutNew = "babu";
        String dineshWithoutNew1 = "dinesh";
        String dineshWithNew = new String("dinesh");
        String babuWithNew = new String("babu");
        dineshWithNew.substring(2);
        String newName1 = "newName1";
        String newName2 = "newName2";

        System.out.println("dineshWithoutNew == dineshWithoutNew = " + (dineshWithoutNew == dineshWithoutNew));
        System.out.println("dineshWithoutNew == babuWithoutNew = " + (dineshWithoutNew == babuWithoutNew));
        System.out.println("babuWithoutNew == babuWithNew = " + (babuWithoutNew == babuWithNew));
        System.out.println("babuWithNew == dineshWithNew = " + (babuWithNew == dineshWithNew));

        System.out.println("dineshWithoutNew.equals(dineshWithNew) = " + dineshWithoutNew.equals(dineshWithoutNew));
        System.out.println("dineshWithoutNew.equals(dineshWithoutNew1) = " + dineshWithoutNew.equals(dineshWithoutNew1));
        System.out.println("babuWithoutNew.equals(babuWithNew) = " + babuWithoutNew.equals(babuWithNew));
    }

    protected static void mutableString() {
        char c = 'c';
        char c1 = 'c';
        if(c == c1) System.out.println("c == c1");
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
                StringBuilder
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
        for (int i=0; i<10_000; i++){
            sb2.append("Tpoint");
        }
        System.out.println("Time taken by StringBuilder: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}


