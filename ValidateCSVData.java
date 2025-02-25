import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "students.csv";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "\\d{10}";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (!emailPattern.matcher(columns[2]).matches()) {
                    System.out.println("Invalid Email: " + columns[2]);
                }
                if (!phonePattern.matcher(columns[3]).matches()) {
                    System.out.println("Invalid Phone Number: " + columns[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
