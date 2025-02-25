import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";
        Map<String, String[]> studentData = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                studentData.put(columns[0], new String[]{columns[1], columns[2], "", ""});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (studentData.containsKey(columns[0])) {
                    studentData.put(columns[0], new String[]{studentData.get(columns[0])[0], studentData.get(columns[0])[1], columns[1], columns[2]});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade\n");
            for (Map.Entry<String, String[]> entry : studentData.entrySet()) {
                bw.write(entry.getKey() + "," + String.join(",", entry.getValue()) + "\n");
            }
            System.out.println("Merged CSV file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
