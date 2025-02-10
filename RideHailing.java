abstract class RideVehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    RideVehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    abstract double calculateFare(double distance);
}

class RideCar extends RideVehicle {
    RideCar(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    double calculateFare(double distance) {
        return distance * 10;
    }
}

public class RideHailing {
    public static void main(String[] args) {
        RideVehicle car = new RideCar("C123", "Amit", 10);
        System.out.println("Fare: " + car.calculateFare(15));
    }
}
