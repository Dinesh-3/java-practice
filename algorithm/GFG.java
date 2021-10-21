package algorithm;



// Java Program to find the longest common prefix

class GFG {

    public static void main(String[] args) {
        String arr[] = {"geeksforgeeks", null,
                "gekk", "geezer"};
        String target = arr[0];

        for (int i = 1; i < arr.length; i++) {
            target = getPrefix(target, arr[i]);
        }
        System.out.println("target = " + target);
    }

    private static String getPrefix(String target, String other) {
        if(target == null || other == null) return "";
        int index = 0;
        int minLength = Integer.min(target.length(), other.length());
        for (int i = 0; i < minLength; i++) {
            if(target.charAt(i) == other.charAt(i)) index++;
            else break;
        }
        return target.substring(0,index);
    }
}

