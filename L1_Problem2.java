import java.util.Scanner;
public class L1_Problem2{
	public static void main(String[] main){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number1: ");
		int number1 = input.nextInt();
		System.out.println("Enter the number2: ");
		int number2 = input.nextInt();
		System.out.println("Enter the number3: ");
		int number3 = input.nextInt();
		if(number1 < number2 && number1 < number3){
			System.out.println("Is the first number the smallest? " + true);
		}else{
			System.out.println("Is the first number the smallest? " + false);		
		}
	}
}