//3. Power Calculation
//Write a program that takes two numbers as input: a base and an exponent,
//and prints the result of base raised to the exponent (without using loops or
//conditionals).
import java.util.*;
public class self_problem3{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter base: ");
		double base = sc.nextDouble();
		System.out.print("Enter exponent: ");
		double exponent = sc.nextDouble();
		double result = Math.pow(base, exponent);
		System.out.println("ans is : " + result);
	}
}