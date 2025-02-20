import java.io.*;
import java.nio.file.Files;

public class ImageByteArrayExample {
    public static void main(String[] args) {
        String inputImagePath = "input.jpg";
        String outputImagePath = "output.jpg";

        byte[] imageBytes = convertImageToByteArray(inputImagePath);
        if (imageBytes != null) {
            reconstructImageFromByteArray(imageBytes, outputImagePath);
        }
    }

    private static byte[] convertImageToByteArray(String imagePath) {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            System.out.println("Image successfully converted to byte array.");
            return baos.toByteArray();
        } catch (IOException e) {
            System.out.println("Error reading image: " + e.getMessage());
            return null;
        }
    }

    private static void reconstructImageFromByteArray(byte[] imageBytes, String outputImagePath) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputImagePath)) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Image successfully reconstructed and saved as " + outputImagePath);
        } catch (IOException e) {
            System.out.println("Error writing image: " + e.getMessage());
        }
    }
}
