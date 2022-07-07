package Task2Challenge3;

import java.util.Scanner;

public class Task2Challenge3 {
    public static void main(String[] args) {
        int height = 31;
        int width = 281;
        char[][] grid = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = '.';
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x1 (0 <= x1 <=  30): ");
        int x1 = scanner.nextInt();
        System.out.print("Enter y1 (0 <= y1 <= 280): ");
        int y1 = scanner.nextInt();
        System.out.print("Enter x2 (0 <= x1 <=  30): ");
        int x2 = scanner.nextInt();
        System.out.print("Enter y2 (0 <= y1 <= 280): ");
        int y2 = scanner.nextInt();

        int t;

        float xx = x2 - x1;
        float yy = y2 - y1;
        if (xx * xx > yy * yy) {
            if (x1 > x2) {
                t = x1; x1 = x2; x2 = t;
                t = y1; y1 = y2; y2 = t;
            }
            int y;
            for (int x = x1; x < x2; x++) {
                y = (int) (y1 + (x - x1) / xx * yy);
                grid[x][y] = '*';
            }
        } else {
            if (y1 > y2) {
                t = x1; x1 = x2; x2 = t;
                t = y1; y1 = y2; y2 = t;
            }
            int x;
            for (int y = y1; y < y2; y++) {
                x = (int) (x1 + (y - y1) / yy * xx);
                grid[x][y] = '*';
            }
        }
        grid[x2][y2] = '*';

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
