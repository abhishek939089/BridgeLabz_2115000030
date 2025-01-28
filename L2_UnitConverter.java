public class L2_UnitConverter {
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static void main(String[] args) {
        System.out.println("10 kilometers to miles: " + convertKmToMiles(10));
        System.out.println("6.21 miles to kilometers: " + convertMilesToKm(6.21));
        System.out.println("5 meters to feet: " + convertMetersToFeet(5));
        System.out.println("16.4 feet to meters: " + convertFeetToMeters(16.4));
    }
}
