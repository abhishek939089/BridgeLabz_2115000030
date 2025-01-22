import java.util.*;
public class Problem7{
    public static void main(String[] args){
        double radius = 6378;
		double volumeInKm3 = (4.0 / 3) * Math.PI * Math.pow(radius, 3);
		double volumeInMiles3 = volumeInKm3 / Math.pow(1.609344, 3); 
		System.out.println("The volume of earth in cubic kilometers is " + volumeInKm3 + " and the cubic miles is " + volumeInMiles3);
    }
}
