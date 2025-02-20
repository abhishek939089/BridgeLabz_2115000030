import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPriceMap;
    private Map<String, Double> cartOrderMap;
    private TreeMap<Double, String> sortedCartMap;

    public ShoppingCart() {
        productPriceMap = new HashMap<>();
        cartOrderMap = new LinkedHashMap<>();
        sortedCartMap = new TreeMap<>();
    }

    public void addProduct(String product, double price) {
        productPriceMap.put(product, price);
        cartOrderMap.put(product, price);
        sortedCartMap.put(price, product);
    }

    public void displayCartUnordered() {
        System.out.println("Cart Items (Unordered - HashMap):");
        for (Map.Entry<String, Double> entry : productPriceMap.entrySet()) {
            System.out.println(entry.getKey() + " -> $" + entry.getValue());
        }
    }

    public void displayCartInOrder() {
        System.out.println("\nCart Items (Preserved Order - LinkedHashMap):");
        for (Map.Entry<String, Double> entry : cartOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> $" + entry.getValue());
        }
    }

    public void displayCartSortedByPrice() {
        System.out.println("\nCart Items (Sorted by Price - TreeMap):");
        for (Map.Entry<Double, String> entry : sortedCartMap.entrySet()) {
            System.out.println(entry.getValue() + " -> $" + entry.getKey());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 1200.99);
        cart.addProduct("Headphones", 150.49);
        cart.addProduct("Mouse", 40.75);
        cart.addProduct("Keyboard", 99.99);
        cart.addProduct("Monitor", 300.00);

        cart.displayCartUnordered();
        cart.displayCartInOrder();
        cart.displayCartSortedByPrice();
    }
}
