//2. Perimeter of a Rectangle
//Write a program to calculate the perimeter of a rectangle. Take the length
//and width as inputs and use the formula:
//Perimeter = 2 * (length + width).
import java.util.*;
public class self_problem2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length: ");
		double length = sc.nextDouble();
		System.out.print("Enter width: ");
		double width = sc.nextDouble();
		double perimeter = 2 * (length + width);
		System.out.println("perimeter of a rectangle is : " + perimeter);
	}
}