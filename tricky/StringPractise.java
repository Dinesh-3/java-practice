package tricky;


/**
 * SCP = String Constant Pool

 */
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
        /**
         * String literals are stored in string constant pool in heap memory section
         * if one or more variables are having same content it will reference the same memory space in string pool
         * It is used to reduce memory consumption
         */
        String dineshWithoutNew = "dinesh";
        String dineshWithoutNew1 = "dinesh";

        System.out.println("dineshWithoutNew.hashCode() = " + dineshWithoutNew.hashCode());
        System.out.println("dineshWithoutNew1.hashCode() = " + dineshWithoutNew1.hashCode());

        String babuWithoutNew = "babu";
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

        /**
         * Returns a canonical representation for the string object.
         * A pool of strings, initially empty, is maintained privately by the class String.
         * When the intern method is invoked, if the pool already contains a string equal to this String object as determined by the equals(Object) method, then the string from the pool is returned. Otherwise, this String object is added to the pool and a reference to this String object is returned.
         * It follows that for any two strings s and t, s.intern() == t.intern() is true if and only if s.equals(t) is true
         */

        String s1 = "abced";
        String s2 = new String("abced");
        String s3 = new String("foo");
        String s4 = s1.intern();
        String s5 = s2.intern();

        System.out.println("(s3 == s4) = " + (s3 == s4));;
        System.out.println("s1 == s5 = " + (s1 == s5));

        String stringLiteral = "dinesh_string_intern_check";
        String stringCreatedWithNew = new String("dinesh_string_intern_check");

        System.out.println("(stringLiteral.intern() == stringCreatedWithNew.intern()) = " + (stringLiteral.intern() == stringCreatedWithNew.intern()));

        System.out.println("s1.hashCode() = " + s1.hashCode());

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
        /**
         * Better technique (although still not ideal):
         *
         * Reverse each string you want to insert.
         * Append each string to a StringBuilder.
         * Reverse the entire StringBuilder when you're done
         */
        dinesh.insert(0, "NAME: "); // To insert at beginning O(N^2)
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


