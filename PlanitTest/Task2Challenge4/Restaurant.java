package Task2Challenge4;

public class Restaurant {
    String name;
    Dish[] dishes;
    int nDishes;
    public Restaurant (String name) {
        this.name = name;
        this.dishes = new Dish[101];
        this.nDishes = 0;
    }

    public void addDish (String name, float price) {
        dishes[nDishes++] = (new Dish(name, price));
    }

    public String searchDisc (String s) {
        s.trim();
        for (int i = 0; i < nDishes; i++) {
            if (dishes[i].getName().equals(s)) {
                return (this.name + ", " + dishes[i].getName() + ", $" + dishes[i].getPrice());
            }
        }
        return "";
    }

    public String toString () {
        String res = this.name + "\n";
        for (int i = 0; i < nDishes; i++) {
            res += "---" + dishes[i].getName() + " : $" + dishes[i].getPrice() + "\n";
        }
        return res;
    }
}