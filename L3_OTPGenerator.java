import java.util.HashSet;

public class L3_OTPGenerator {
    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }

    public static boolean areOTPsUnique(int[] otps) {
        HashSet<Integer> uniqueOTPs = new HashSet<>();
        for (int otp : otps) {
            uniqueOTPs.add(otp);
        }
        return uniqueOTPs.size() == otps.length;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
        }
        for (int otp : otps) {
            System.out.println(otp);
        }
        System.out.println(areOTPsUnique(otps) ? "Unique" : "Not Unique");
    }
}
