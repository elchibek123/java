class Circle {
    public double radius;

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public double circumference() {
        return perimeter();
    }
}

class Cylinder extends Circle {
    public double height;

    public double volume() {
        return area() * height;
    }
}

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder c = new Cylinder();

        c.radius = 2;
        c.height = 7;

        System.out.println("Area: " + c.area());
        System.out.println("Volume: " + c.volume());
    }
}