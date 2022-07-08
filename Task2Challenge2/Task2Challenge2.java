import java.util.Scanner;

public class Task2Challenge2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = scan.nextLine();
        scan.close();

        s = s.replace(" ", "");
        s = s.toLowerCase();

        if (s.length() > 0) {
            int maxLen = 0;
            char curChar;
            char maxChar = s.charAt(0);
            int l;

            while (s.length() > 0) {
                //System.out.println(s);
                curChar = s.charAt(0);
                l = s.length();
                s = s.replace("" + curChar, "");
                if (l - s.length() > maxLen) {
                    maxLen = l - s.length();
                    maxChar = curChar;
                }
            }

            System.out.println("Most occurrence character: " + maxChar);
        } else {
            System.out.println("Empty word");
        }
    }
}
