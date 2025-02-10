abstract class Product {
    private int productId;
    private String name;
    private double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    abstract double calculateDiscount();

    double getPrice() {
        return price;
    }

    void displayFinalPrice() {
        double discount = calculateDiscount();
        System.out.println(name + " Final Price: " + (price - discount));
    }
}

class Electronics extends Product {
    Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    double calculateDiscount() {
        return getPrice() * 0.1;
    }
}

public class ECommerce {
    public static void main(String[] args) {
        Product p1 = new Electronics(201, "Laptop", 70000);
        p1.displayFinalPrice();
    }
}
