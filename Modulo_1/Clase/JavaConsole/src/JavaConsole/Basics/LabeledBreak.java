package JavaConsole.Basics;

public class LabeledBreak {
    public static void main(String[] args){
        boolean t = true;
        first:
        {
            second:
            {
                third:
                {
                    System.out.println("Before the break");
                    if (t) // break out of second block
                        break second;
                }
                System.out.println("This won't execute");
            }
            System.out.println("This is after the second block");
        }
    }
}
