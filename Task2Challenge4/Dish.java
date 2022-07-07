package Task2Challenge4;

import java.util.Locale;

public class Dish {
    private String name;
    private float price;

    public Dish(String name, float price) {
        this.name = name.toLowerCase();
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}