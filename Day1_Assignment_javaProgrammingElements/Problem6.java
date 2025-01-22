import java.util.*;
public class Problem6{
    public static void main(String[] args){
        double fee = 125000;
		double discountPercent = 10;
		double discount = (fee * discountPercent) / 100;
		double discountFee = fee - discount; 
		System.out.println("The discount amount is INR " + discount + " and the final discounted fee is INR " + discountFee);
    }
}
