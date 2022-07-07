package Task2Challenge4;
import java.util.Scanner;

public class Task2Challenge4 {
    public static Restaurant[] restaurants = new Restaurant[101];
    public static int nRestaurants = 3;
    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < nRestaurants; i++) {
            System.out.println(restaurants[i]);
        }

        System.out.print("What do you want to order: ");
        String dishName = scanner.nextLine();

        dishName = dishName.trim().toLowerCase();
        Boolean found = false;
        String res;
        for (int i = 0; i < nRestaurants; i++) {
            res = restaurants[i].searchDisc(dishName);
            if (!res.equals("")) {
                found = true;
                System.out.println(res);
                break;
            }
        }

        if (!found) {
            System.out.println("Dish not found");
        }
        scanner.close();
    }

    private static void init() {
        Restaurant r;
        r = new Restaurant("Burger King");
        r.addDish("burger", 15);
        r.addDish("chicken nugget", 10);
        r.addDish("whopper", 12);
        restaurants[0] = r;

        r = new Restaurant("KFC");
        r.addDish("chicken burger", 20);
        r.addDish("wicked wing", 3);
        r.addDish("chip", 5);
        restaurants[1] = r;

        r = new Restaurant("Pizza hut");
        r.addDish("pizza", 20);
        r.addDish("cheese stick", 5);
        r.addDish("garlic bread", 3);
        restaurants[2] = r;
    }

    public String invoiceExport(String disc) {
        String invoice = "";
        return invoice;
    }
}