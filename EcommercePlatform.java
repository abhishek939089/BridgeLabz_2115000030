import java.util.ArrayList;
import java.util.List;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    List<Product> products;

    Order() {
        this.products = new ArrayList<>();
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void displayOrder() {
        System.out.println("Order contains:");
        for (Product product : products) {
            System.out.println(product.name + " - $" + product.price);
        }
    }
}

class Customer {
    String name;
    List<Order> orders;

    Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    void placeOrder(Order order) {
        orders.add(order);
    }

    void displayOrders() {
        System.out.println("Customer: " + name);
        for (Order order : orders) {
            order.displayOrder();
        }
    }
}

public class EcommercePlatform {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice");

        Product p1 = new Product("Laptop", 1200);
        Product p2 = new Product("Phone", 800);

        Order order1 = new Order();
        order1.addProduct(p1);
        order1.addProduct(p2);

        customer.placeOrder(order1);
        customer.displayOrders();
    }
}
