package worksheet3.Q1;

public class Temperature {
    private double celsius;
    private  double fahrenheit;

    public Temperature() {
        celsius = 0;
    }

    public Temperature(double celsius) {
        this.celsius = celsius;
    }

    public double toCelsius() {
        return celsius = (fahrenheit - 32) * 5 / 9 ;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public double toFahrenheit() {
        return fahrenheit = (celsius * 9 / 5) + 32 ;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }
}
