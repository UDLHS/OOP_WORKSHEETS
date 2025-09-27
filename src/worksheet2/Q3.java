package worksheet2;

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();

        for (int i = 1; i <= rows; i++){
            for (int z = rows; z >= i+1 ;z--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i ;j++) {
                System.out.print("* ");
            }
            System.out.print("\n");

        }
    }

}
