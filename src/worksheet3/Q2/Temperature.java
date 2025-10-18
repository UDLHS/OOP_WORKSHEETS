package worksheet3.Q2;

public class Temperature {
    private double celsius;
    private  double fahrenheit;

    public Temperature(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public double toCelsius() {
        return celsius;
    }

    public void setCelsius() {
        celsius = (fahrenheit - 32) * 5 / 9 ;
    }

    public double toFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit() {
        fahrenheit = (celsius * 9 / 5) + 32 ;
    }
}




































































