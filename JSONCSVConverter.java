import org.json.*;
import java.io.*;
import java.util.*;

public class JSONCSVConverter {
    public static void main(String[] args) throws IOException {
        convertJSONToCSV("students.json", "students.csv");
        convertCSVToJSON("students.csv", "students_converted.json");
    }

    public static void convertJSONToCSV(String jsonFile, String csvFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
        StringBuilder jsonText = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonText.append(line);
        }
        reader.close();

        JSONArray jsonArray = new JSONArray(jsonText.toString());
        BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
        JSONObject firstObj = jsonArray.getJSONObject(0);
        writer.write(String.join(",", firstObj.keySet()) + "\n");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            writer.write(obj.get("ID") + "," + obj.get("Name") + "," + obj.get("Age") + "," + obj.get("Marks") + "\n");
        }
        writer.close();
        System.out.println("JSON converted to CSV.");
    }

    public static void convertCSVToJSON(String csvFile, String jsonFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String[] headers = reader.readLine().split(",");
        JSONArray jsonArray = new JSONArray();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            JSONObject obj = new JSONObject();
            for (int i = 0; i < headers.length; i++) {
                obj.put(headers[i], values[i]);
            }
            jsonArray.put(obj);
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile));
        writer.write(jsonArray.toString(4));
        writer.close();
        System.out.println("CSV converted to JSON.");
    }
}
