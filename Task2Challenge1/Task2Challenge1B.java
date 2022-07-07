import java.util.Scanner;

public class Task2Challenge1B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String n = scan.nextLine();
        scan.close();
        BigInt target = new BigInt(n);

        long i = 1;
        BigInt  x = new BigInt (0);
        BigInt  y = new BigInt (1);
        BigInt  t;
        while (y.compare(target) < 0) {
            t = x.add(y);
            x = y;
            y = t;
            i++;
        }

        if (y.compare(target) == 0) {
            System.out.println(n + "'s Fibonacci index is " + i);
        } else {
            BigInt s1 = target.subtract(x);
            BigInt s2 = y.subtract(target);
            if (s1.compare(s2) < 0) {
                System.out.println(n + "'s closest Fibonacci index is " + (i - 1));
            } else {
                System.out.println(n + "'s closest Fibonacci index is " + i);
            }
        }
    }
}