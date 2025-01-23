import java.util.Scanner;
public class L1_Problem1{
	public static void main(String[] main){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int number = input.nextInt();
		if(number % 5 == 0){
			System.out.println("Is the number " + number + " divisible by 5? " + true);
		}else{
			System.out.println("Is the number " + number + " divisible by 5? " + false);
		}
	}
}