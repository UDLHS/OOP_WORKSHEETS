import java.util.Scanner;

public class Q3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double length = scanner.nextDouble();

        double inches = length / 2.54;
        int feet = (int) (inches/12);

        inches %= 12;

        System.out.println((length)+"cm = "+feet+" feet and "+inches+" inches");

    }
}
