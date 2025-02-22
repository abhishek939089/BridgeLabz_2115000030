import java.util.regex.*;

public class ValidateIPAddress {
    public static void main(String[] args) {
        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(regex);

        String[] ips = {"192.168.1.1", "256.256.256.256", "0.0.0.0", "255.255.255.255", "192.168.1"};

        for (String ip : ips) {
            Matcher matcher = pattern.matcher(ip);
            System.out.println(ip + " is valid: " + matcher.matches());
        }
    }
}