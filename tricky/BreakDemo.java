package tricky;

class BreakDemo {
    public static void main(String args[])
    {
        boolean t = true;

        // label first
        first : {

            // Illegal statement here
            // as label second is not
            // introduced yet break second;
            second : {
                third : {
                    // Before break
                    System.out.println("Before the break statement");

                    // break will take the control out of
                    // second label
                    if (t)
                        break second;
                    System.out.println("This won't execute.");
                }
                System.out.println("This won't execute.");
            }
            Object object = new Object();
            // First block
            System.out.println("This is after second block.");
        }

    }
}
