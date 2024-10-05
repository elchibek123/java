abstract class Super {
    public Super() { System.out.println("Super Constructor"); }
    
    public void meth1() {
        System.out.println("Meth1 of Super");
    }
    
    abstract public void meth2();
}

class Sub extends Super {
    @Override
    public void meth2() {
        System.out.println("Sub meth2");
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        Super s=new Sub();
        s.meth1();
        s.meth2();
    }    
}

// Example

abstract class Shape {
   abstract public double perimeter();
   abstract public double area();
}

class Circle extends Shape {
    double radius;
    
    public double perimeter() {
        return 2*Math.PI*radius;
    }

    public double area() {
        return Math.PI*radius*radius;
    }   
}
        
class Rectangle extends Shape {
    double length;
    double breadth;
    
    public double perimeter() {
        return 2*(length+breadth);
    }

    public double area() {
        return length*breadth;
    } 
}

public class AbstractClass {
    public static void main(String[] args) {
        Rectangle r=new Rectangle();
        r.length=10;
        r.breadth=5;
        
        Shape s=r;
        
        System.out.println(s.area());
        
    }  
}

// Test