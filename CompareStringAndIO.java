import java.io.*;

public class CompareStringAndIO {
    public static void main(String[] args) {
        compareStringBuilderAndBuffer();
        compareFileReadingMethods("largefile.txt");
    }

    public static void compareStringBuilderAndBuffer() {
        int iterations = 1_000_000;
        String text = "hello";

        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void compareFileReadingMethods(String filePath) {
        try {
            long startTime = System.nanoTime();
            int wordCount = countWordsUsingFileReader(filePath);
            long endTime = System.nanoTime();
            System.out.println("FileReader Word Count: " + wordCount + " (Time: " + (endTime - startTime) / 1_000_000 + " ms)");

            startTime = System.nanoTime();
            wordCount = countWordsUsingInputStreamReader(filePath);
            endTime = System.nanoTime();
            System.out.println("InputStreamReader Word Count: " + wordCount + " (Time: " + (endTime - startTime) / 1_000_000 + " ms)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countWordsUsingFileReader(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int wordCount = 0;
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            return wordCount;
        }
    }

    public static int countWordsUsingInputStreamReader(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            int wordCount = 0;
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            return wordCount;
        }
    }
}
