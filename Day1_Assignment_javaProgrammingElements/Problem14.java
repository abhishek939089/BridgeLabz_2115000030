import java.util.Scanner;

public class Problem14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = input.nextDouble();
        
        double distanceInYards = distanceInFeet / 3;
        double distanceInMiles = distanceInYards / 1760;
        
        System.out.println("The distance is " + distanceInFeet + " feet, which is " + distanceInYards + " yards and " + distanceInMiles + " miles.");
    }
}
