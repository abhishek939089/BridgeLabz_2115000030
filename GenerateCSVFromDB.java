import java.io.*;
import java.sql.*;

public class GenerateCSVFromDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "password";
        String outputFile = "employees.csv";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, department, salary FROM employees");
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            writer.write("Employee ID,Name,Department,Salary\n");
            while (rs.next()) {
                writer.write(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getDouble(4) + "\n");
            }
            System.out.println("CSV Report Generated Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
