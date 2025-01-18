import java.util.*;
public class randomDigit{
	public static void main(String[] args){
		Random random = new Random();
		int[] numbers = new int[5];
		System.out.println("Generated 3-digit random numbers:");
		for(int i=0; i<numbers.length; i++){
			numbers[i] = random.nextInt(900) + 100;
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		int max = numbers[0];
		int min = numbers[0];
		for(int i=1; i<numbers.length; i++){
			if(numbers[i] > max){
				max = numbers[i];
			}
			if(numbers[i] < min){
				min = numbers[i];
			}
		}
		System.out.println("Max value: " + max);
		System.out.println("Min value: " + min);
	}
}
