import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConvertUppercaseToLowercase {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        convertFileToLowercase(inputFile, outputFile);
    }

    private static void convertFileToLowercase(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile, StandardCharsets.UTF_8));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, StandardCharsets.UTF_8))) {
            
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }

            System.out.println("File converted successfully: Uppercase → Lowercase.");
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
