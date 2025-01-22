import java.util.Scanner;

public class L2_Problem8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the city you are traveling from: ");
        String fromCity = scanner.nextLine();

        System.out.print("Enter the via city: ");
        String viaCity = scanner.nextLine();

        System.out.print("Enter the city you are traveling to: ");
        String toCity = scanner.nextLine();

        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " (in miles): ");
        double fromToVia = scanner.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " (in miles): ");
        double viaToFinalCity = scanner.nextDouble();

        System.out.print("Enter the total time taken for the journey (in hours): ");
        double timeTaken = scanner.nextDouble();

        double totalDistance = fromToVia + viaToFinalCity;

        double averageSpeed = totalDistance / timeTaken;
		
        System.out.println("\nJourney Details:");
        System.out.println("Name: " + name);
        System.out.println("From: " + fromCity);
        System.out.println("Via: " + viaCity);
        System.out.println("To: " + toCity);
        System.out.println("Total Distance: " + totalDistance + " miles");
        System.out.println("Time Taken: " + timeTaken + " hours");
        System.out.println("Average Speed: " + averageSpeed + " miles/hour");
    }
}
