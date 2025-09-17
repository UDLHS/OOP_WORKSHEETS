import java.util.Scanner;

public class Q2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your full name as three parts:(first middle last)-> ");
        String fullName = scanner.nextLine();
        String[] names = fullName.split(" ");

        String last = names[2];
        String[] middle = names[1].split("");
        String first = names[0];

        System.out.println("Name: "+last+" "+first+" "+middle[0]+".");



    }
}
