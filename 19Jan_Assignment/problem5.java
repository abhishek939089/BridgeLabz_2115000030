//5. Volume of a Cylinder
//Write a program to calculate the volume of a cylinder. Take the radius and
//height as inputs and use the formula:
//Volume = π * radius^2 * height.
import java.util.*;
public class problem5{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter radius: ");
		double radius = sc.nextDouble();
		System.out.print("Enter height: ");
		double height = sc.nextDouble();
		double volumeOfCylinder = Math.PI * Math.pow(radius, 2) * height;
		System.out.println("volume of a cylinder is : " + volumeOfCylinder);
	}
}
