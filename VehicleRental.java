abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    abstract double calculateRentalCost(int days);
}

class Car extends Vehicle {
    Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    double calculateRentalCost(int days) {
        return days * 50;
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        Vehicle car = new Car("MH12AB1234", 50);
        System.out.println("Rental Cost: " + car.calculateRentalCost(5));
    }
}
