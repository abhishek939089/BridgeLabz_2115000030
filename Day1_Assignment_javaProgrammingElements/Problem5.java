import java.util.*;
public class Problem5{
    public static void main(String[] args){
        int totalPens = 14;
		int noOfStudents = 3;
		int distributedPens = totalPens / noOfStudents;
		int remainder = totalPens % noOfStudents; 
		System.out.println("The Pen Per Student is " + distributedPens + " and the remaining pen not distributed is " + remainder);
    }
}
