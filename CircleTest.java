class Circle {
    private double radius;

    public double getRadius() {
        return radius;
    }
    public void setRadius(double r) {
        if (r > 0) {
            radius = r;
        } else {
            radius = 0;
        }
    }
    public double area() {
        return Math.PI * getRadius() * getRadius();
    }
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
    public double circumfernce() {
        return perimeter();
    }
}

public class CircleTest {
    public static void main(String[] arg) {
        Circle c = new Circle();
        Circle c1 = new Circle();
        c.setRadius(-12);
        c1.setRadius(5);
        System.out.println("Circle area: " + c.area());
        System.out.println("Circle perimeter: " + c.perimeter());
        System.out.println("Circle circumfernce: " + c.circumfernce());
        System.out.println("Radius: " + c.getRadius());
        System.out.println();
        System.out.println("Circle area1: " + c1.area());
        System.out.println("Circle perimeter1: " + c1.perimeter());
        System.out.println("Circle circumfernce1: " + c1.circumfernce());
        System.out.println("Radius1: " + c1.getRadius());
    }
}