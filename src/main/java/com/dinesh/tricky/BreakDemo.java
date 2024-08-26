package com.dinesh.tricky;

class BreakDemo {
    public static void main(String args[])
    {
        for (int i = 0; i < 10; i++) first: {
            for (int j = 0; j < 10; j++) {
                System.out.println(i + "," + j);
                if(i != j) {
                    System.out.println("Breaking");
                    break first;
                }

            }
        }

        boolean isBreak = true;

        // label first
        first : {

            // Illegal statement here
            // as label second is not
            // introduced yet break second;
            System.out.println("FIRST START");
            second : {
                System.out.println("SECOND START");
                third : {
                    // Before break
                    System.out.println("THIRD Before the break statement");

                    // break will take the control out of
                    // second label
                    if (isBreak)
                        break second;
                    System.out.println("THIRD AFTER This won't execute.");
                }
                System.out.println("SECOND END ");
            }
            Object object = new Object();
            // First block
            System.out.println("FIRST END");

        }

    }
}
