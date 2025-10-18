package worksheet3.Q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double temp;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature : ");
        temp = scanner.nextDouble();
//        System.out.print("Enter unit of temperature (C/F ) : ");

        Temperature temperature = new Temperature(temp);
        System.out.printf("%.2f°c = %.2fF ",temp,temperature.toFahrenheit());

        scanner.close();
    }
}
