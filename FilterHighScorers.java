import java.io.*;

public class FilterHighScorers {
    public static void main(String[] args) {
        String filePath = "students.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (Integer.parseInt(columns[3]) > 80) {
                    System.out.println("ID: " + columns[0] + ", Name: " + columns[1] + ", Marks: " + columns[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
