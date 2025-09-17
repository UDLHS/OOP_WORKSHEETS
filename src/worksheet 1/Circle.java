import java.util.Scanner;

public class Circle {
    int r1 = 0;
    int r2 = 0;

    public double computeArea(int r){
        return 3.14 * r * r;
    }

    public double computeCircumference(int r){
        return 2 * 3.14 * r;
    }

    public void setRadius(int r1, int r2){
        Scanner scanner = new Scanner(System.in);

        r1 = scanner.nextInt();
        r2 = scanner.nextInt();

        this.r1 = r1;
        this.r2 = r2;
    }

    public static void main(String[] args){
        Circle circle = new Circle();

        circle.setRadius(circle.r1, circle.r2);

        double areaOfBig = circle.computeArea(circle.r1);
        double areaOfSmall = circle.computeArea(circle.r2);

        double CircularOfBig = circle.computeCircumference(circle.r1);
        double CircularOfSmall = circle.computeCircumference(circle.r2);

        // Show results
        System.out.println("Area of Big Circle: " + areaOfBig);
        System.out.println("Area of Small Circle: " + areaOfSmall);
        System.out.println("Circumference of Big Circle: " + CircularOfBig);
        System.out.println("Circumference of Small Circle: " + CircularOfSmall);
    }
}
