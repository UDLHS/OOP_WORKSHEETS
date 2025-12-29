package worksheet4.Q1;

import java.util.Scanner;
import java.util.Arrays;

public class Q1 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int smallest = 0, largest = 0;

        int[] numbers = new int[3];

        for (int i = 0; i < numbers.length; i++){
            System.out.println("Enter the number "+(i+1));
            numbers[i] = scanner.nextInt();
        }

        largest = numbers[0];
        smallest = numbers[0];

        for (int number : numbers) {

            if (largest < number) {
                largest = number;
            }
            if (smallest > number) {
                smallest = number;
            }
        }

        System.out.printf("Smallest number: %d\nLargest number: %d", smallest, largest);

    }

}
