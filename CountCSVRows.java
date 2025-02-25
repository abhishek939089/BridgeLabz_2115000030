import java.io.*;

public class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        int rowCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); 
            while (br.readLine() != null) {
                rowCount++;
            }
            System.out.println("Total Records (excluding header): " + rowCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
