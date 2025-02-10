abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    abstract double calculateTotalPrice();

    void getItemDetails() {
        System.out.println("Item: " + itemName + ", Total Price: " + calculateTotalPrice());
    }
}

class VegItem extends FoodItem {
    VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem {
    NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 50;
    }
}

public class FoodDelivery {
    public static void main(String[] args) {
        FoodItem f1 = new VegItem("Paneer Butter Masala", 200, 2);
        FoodItem f2 = new NonVegItem("Chicken Biryani", 250, 1);

        f1.getItemDetails();
        f2.getItemDetails();
    }
}
