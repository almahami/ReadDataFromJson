package json.mohammad.Models;

public class ExtendedStatistics {

    private double area;

    public ExtendedStatistics(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "ExtendedStatistics [area=" + area + "]";
    }
}
