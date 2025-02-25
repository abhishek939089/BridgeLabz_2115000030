import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSV {
    private static final String KEY = "1234567890123456";

    public static void main(String[] args) {
        encryptCSV("employees.csv", "encrypted.csv");
        decryptCSV("encrypted.csv", "decrypted.csv");
    }

    public static void encryptCSV(String inputFile, String outputFile) {
        processCSV(inputFile, outputFile, true);
    }

    public static void decryptCSV(String inputFile, String outputFile) {
        processCSV(inputFile, outputFile, false);
    }

    private static void processCSV(String inputFile, String outputFile, boolean encrypt) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            bw.write(br.readLine() + "\n");
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                columns[3] = encrypt ? encrypt(columns[3]) : decrypt(columns[3]);
                bw.write(String.join(",", columns) + "\n");
            }
            System.out.println((encrypt ? "Encryption" : "Decryption") + " completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String encrypt(String value) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY.getBytes(), "AES"));
        return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes()));
    }

    private static String decrypt(String value) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(KEY.getBytes(), "AES"));
        return new String(cipher.doFinal(Base64.getDecoder().decode(value)));
    }
}
