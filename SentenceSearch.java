import java.util.Scanner;

public class SentenceSearch {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of sentences: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] sentences = new String[n];
        System.out.println("Enter sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = scanner.nextLine();
        }
        System.out.print("Enter the word to search: ");
        String word = scanner.nextLine();
        String result = findSentenceWithWord(sentences, word);
        System.out.println("Sentence containing the word: " + result);
        scanner.close();
    }
}
