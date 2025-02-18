import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealType();
    String getDetails();
}

class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }

    public String getDetails() {
        return "Includes plant-based foods, dairy, and eggs.";
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }

    public String getDetails() {
        return "Strictly plant-based, no animal products.";
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto";
    }

    public String getDetails() {
        return "Low-carb, high-fat diet.";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein";
    }

    public String getDetails() {
        return "Focuses on high protein intake.";
    }
}

class Meal<T extends MealPlan> {
    private T mealType;
    private List<String> foodItems;

    public Meal(T mealType) {
        this.mealType = mealType;
        this.foodItems = new ArrayList<>();
    }

    public void addFoodItem(String item) {
        foodItems.add(item);
    }

    public void displayMealPlan() {
        System.out.println("Meal Type: " + mealType.getMealType());
        System.out.println("Details: " + mealType.getDetails());
        System.out.println("Food Items: " + foodItems);
    }
}

class MealGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealType, List<String> items) {
        Meal<T> meal = new Meal<>(mealType);
        for (String item : items) {
            meal.addFoodItem(item);
        }
        return meal;
    }
}

public class MealPlanSystem {
    public static void main(String[] args) {
        List<String> vegItems = List.of("Salad", "Paneer", "Rice");
        Meal<VegetarianMeal> vegMeal = MealGenerator.generateMealPlan(new VegetarianMeal(), vegItems);

        List<String> ketoItems = List.of("Avocado", "Chicken", "Cheese");
        Meal<KetoMeal> ketoMeal = MealGenerator.generateMealPlan(new KetoMeal(), ketoItems);

        System.out.println("Generated Meal Plans:");
        vegMeal.displayMealPlan();
        System.out.println();
        ketoMeal.displayMealPlan();
    }
}
