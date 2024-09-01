class Rectangle {
    private double length;
    private double breadth;

    public Rectangle() {
        length = 1;
        breadth = 1;
    }
    public  Rectangle(double l, double b) {
        length = l;
        breadth = b;
    }
    public Rectangle(double s) {
        length = breadth = s;
    }
    public double getLength() {
        return length;
    }
    public double getBreadth() {
        return breadth;
    }
    public void setLength(double l) {
        if (l > 0) {
            length = l;
        } else {
            length = 0;
        }
    }
    public void setBreadth(double b) {
        if (b > 0) {
            breadth = b;
        } else {
            breadth = 0;
        }
    }
    public double area() {
        return getLength() * getBreadth();
    }
    public double perimeter() {
        return 2 * (length + breadth);
    }
    public boolean isSquare() {
        if (length == breadth) {
            return true;
        } else {
            return false;
        }
    }
}

public class RectangleTest{
    public static void main(String[] args) {
        Rectangle r = new Rectangle(5, 2);
        r.setLength(6);
        r.setBreadth(3);

        System.out.println(r.getLength());
        System.out.println(r.getBreadth());

        System.out.println(r.area());
        System.out.println(r.perimeter());
        System.out.println(r.isSquare());
    }
}
