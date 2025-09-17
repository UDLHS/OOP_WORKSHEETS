import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the odd length text:");
        String text = scanner.next();

        int length = text.length()/2;

        System.out.print("The middle letter is " + text.charAt(length) + ".");
    }
}
