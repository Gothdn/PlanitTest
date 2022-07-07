import java.util.Scanner;

public class Task2Challenge1A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any number: ");

        long n = scan.nextInt();
        scan.close();

        if (n < 0) {
            System.out.println("Invalid n");
        } else if (n == 0) {
            System.out.println("Result: 0");
        } else if (n == 1) {
            System.out.println("Result: 1");
        }else {
            long i = 1;
            BigInt  x = new BigInt (0);
            BigInt  y = new BigInt (1);
            BigInt  t;
            while (i < n) {
                t = x.add(y);
                x = y;
                y = t;
                i++;
                //System.out.println(y);
            }

            System.out.println("Result: " + y);
        }
    }
}