package worksheet2;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args){
        int x = 10;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 10; j++){
                System.out.print(x + " ");
                x += 1;
            }
            System.out.print("\n");
        }
    }
}