import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "students.csv";
        Set<String> uniqueIds = new HashSet<>();
        Set<String> duplicateIds = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String id = line.split(",")[0];
                if (!uniqueIds.add(id)) {
                    duplicateIds.add(id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!duplicateIds.isEmpty()) {
            System.out.println("Duplicate Records Found:");
            for (String id : duplicateIds) {
                System.out.println("Duplicate ID: " + id);
            }
        } else {
            System.out.println("No duplicate records found.");
        }
    }
}
