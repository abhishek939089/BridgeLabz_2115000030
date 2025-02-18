import java.util.ArrayList;
import java.util.List;

abstract class ProductCategory {
    private String name;

    public ProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class BookCategory extends ProductCategory {
    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super("Gadgets");
    }
}

class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }
}

class Marketplace {
    private List<Product<?>> catalog = new ArrayList<>();

    public void addProduct(Product<?> product) {
        catalog.add(product);
    }

    public void displayCatalog() {
        for (Product<?> product : catalog) {
            System.out.println(product.getName() + " | Category: " + product.getCategory().getName() + " | Price: $" + product.getPrice());
        }
    }
}

class DiscountUtility {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 50.0, new BookCategory());
        Product<ClothingCategory> tshirt = new Product<>("Graphic T-Shirt", 20.0, new ClothingCategory());
        Product<GadgetCategory> smartphone = new Product<>("Smartphone", 700.0, new GadgetCategory());

        Marketplace marketplace = new Marketplace();
        marketplace.addProduct(book);
        marketplace.addProduct(tshirt);
        marketplace.addProduct(smartphone);

        System.out.println("Before Discount:");
        marketplace.displayCatalog();

        DiscountUtility.applyDiscount(book, 10);
        DiscountUtility.applyDiscount(tshirt, 5);
        DiscountUtility.applyDiscount(smartphone, 15);

        System.out.println("\nAfter Discount:");
        marketplace.displayCatalog();
    }
}
