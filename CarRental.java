class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double totalCost;

    CarRental() {
        customerName = "Default Customer";
        carModel = "Toyota Corolla";
        rentalDays = 3;
        totalCost = rentalDays * 50.0;
    }

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.totalCost = rentalDays * 50.0;
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental();
        CarRental rental2 = new CarRental("Mike", "Tesla Model 3", 5);

        System.out.println(rental1.customerName + " - " + rental1.carModel + " - " + rental1.rentalDays + " days - $" + rental1.totalCost);
        System.out.println(rental2.customerName + " - " + rental2.carModel + " - " + rental2.rentalDays + " days - $" + rental2.totalCost);
    }
}
