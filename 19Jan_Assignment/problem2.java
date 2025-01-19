//2. Add Two Numbers
//Write a program that takes two numbers as input from the user and prints
//their sum.

import java.util.*;
public class problem2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number :"
		int a = sc.nextInt();
		System.out.println("Enter second number :");
		int b = sc.nextInt();
		System.out.print("Addition of two numbers is : " + (a+b));
	}
}