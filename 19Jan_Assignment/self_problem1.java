//Self Problems
//1. Calculate Simple Interest
//Write a program to calculate simple interest using the formula:
//Simple Interest = (Principal * Rate * Time) / 100.
//Take Principal, Rate, and Time as inputs from the user.
import java.util.*;
public class self_problem1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter principal: ");
		double principal = sc.nextDouble();
		System.out.print("Enter rate: ");
		double rate = sc.nextDouble();
		System.out.print("Enter time: ");
		double time = sc.nextDouble();
		double simpleInterest = (principal * rate * time) / 100;
		System.out.println("simple interest is : " + simpleInterest);
	}
}
