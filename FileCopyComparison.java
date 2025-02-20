import java.io.*;

public class FileCopyComparison {
    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {
        File sourceFile = new File("largefile.bin"); 
        File destBuffered = new File("output_buffered.bin");
        File destUnbuffered = new File("output_unbuffered.bin");

        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }

        long unbufferedTime = copyUsingUnbufferedStreams(sourceFile, destUnbuffered);
        long bufferedTime = copyUsingBufferedStreams(sourceFile, destBuffered);

        System.out.println("Unbuffered Copy Time: " + (unbufferedTime / 1_000_000) + " ms");
        System.out.println("Buffered Copy Time: " + (bufferedTime / 1_000_000) + " ms");
    }

    private static long copyUsingUnbufferedStreams(File source, File destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Unbuffered copy failed: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }

    private static long copyUsingBufferedStreams(File source, File destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Buffered copy failed: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}
