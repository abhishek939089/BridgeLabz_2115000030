import java.util.*;
public class Problem8{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		System.out.println("Enter distance in kilometers :");
		double distanceInkm = input.nextDouble();
		double distanceInmiles = distanceInkm / 1.6;
		System.out.println("The total miles is " + distanceInmiles + " mile for the given " + distanceInkm + " km ");
    }
}
