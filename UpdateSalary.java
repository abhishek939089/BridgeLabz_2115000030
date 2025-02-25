import java.io.*;

public class UpdateSalary {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(br.readLine() + "\n");
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[2].equalsIgnoreCase("IT")) {
                    columns[3] = String.valueOf((int) (Integer.parseInt(columns[3]) * 1.10));
                }
                writer.write(String.join(",", columns) + "\n");
            }
            System.out.println("Salary updated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
