package worksheet2;

import java.util.Scanner;

public class Q2 {

    static int returnDigits(int number){

        int length = 0;
        int numb = number;

        while (number > 0){
            number = number/10;
            length += 1;
        }

        return length;

    }

    public static void main(String[] args){

        boolean condition = true;

        while (condition){
            System.out.println("Enter the number: ");
            Scanner scanner = new Scanner(System.in);

            int number = scanner.nextInt();

            if (number > 0){
                int length = returnDigits(number);

                System.out.println("length of number is " + length+ ".");
            }else {
                break;
            }
        }




    }
}
