import java.util.Random;

public class a0478Solution {
    private double radius;
    private double x_center;
    private double y_center;
    private Random random;

    public a0478Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        random = new Random();
    }

    public double[] randPoint() {
        double value = random.nextDouble();
        double theta = random.nextDouble() * 2 * Math.PI;
        double r = Math.sqrt(value);
        return new double[]{
                x_center + r * Math.cos(theta) * radius,
                y_center + r * Math.sin(theta) * radius
        };
    }
}
