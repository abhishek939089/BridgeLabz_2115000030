//4. Calculate Average of Three Numbers
//Write a program that takes three numbers as input from the user and prints
//their average.
import java.util.*;
public class self_problem4{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: "
		double a = sc.nextDouble();
		System.out.print("Enter second number: ");
		double b = sc.nextDouble();
		System.out.print("Enter third number: ");
		double c = sc.nextDouble();
		double average = (a + b + c) / 3;
		System.out.println("average of three numbers is : " + average);
	}
}