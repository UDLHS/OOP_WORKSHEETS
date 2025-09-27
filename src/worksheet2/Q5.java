package worksheet2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();

        // Use StringTokenizer to split sentence into words
        StringTokenizer tokenizer = new StringTokenizer(sentence);
        StringBuilder cleaned = new StringBuilder();

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            // Remove all non-letter characters from each word
            word = word.replaceAll("[^a-zA-Z]", "");
            // Convert to lowercase and append to cleaned string
            cleaned.append(word.toLowerCase());
        }

        // Get the cleaned string
        String cleanedString = cleaned.toString();
        // Reverse the cleaned string
        String reversedString = cleaned.reverse().toString();

        // Check if palindrome
        if (cleanedString.equals(reversedString)) {
            System.out.println("The sentence is a palindrome!");
        } else {
            System.out.println("The sentence is NOT a palindrome.");
        }
    }
}
