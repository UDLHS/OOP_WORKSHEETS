package worksheet3.Q2;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double temp;
        char unit;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature : ");
        temp = scanner.nextDouble();

            Temperature temperature = new Temperature(temp);
            temperature.setCelsius();
            double c = temperature.toCelsius();
            System.out.printf("%.2fF= %.2f°c  ",temp,c);






        scanner.close();
    }
}
