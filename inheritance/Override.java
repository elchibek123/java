class Super {
    public void display() {
        System.out.println("Super Display");
    }
}

class Sub extends Super {
    public void display() {
        System.out.println("Sub Display");
    }
}

public class Override {
    public static void main(String[] args) {
        Super s=new Sub();
        s.display(); 
    }    
}

// Example #1

class TV {
    public void switchON(){ System.out.println("TV is Switched ON"); }
    
    public void changeChannel() { System.out.println("TV Channel is Changed "); }
}

class SmartTV extends TV {
    @Override
    public void switchON(){ System.out.println("Smart TV is Switched ON"); }
    
    @Override
    public void changeChannel() { System.out.println("Smart TV Channel is Changed "); }
    
    public void browse(){ System.out.println("Smart TV Browsing"); } 
}

public class OverrideExample {

    public static void main(String[] args) {
        TV t=new SmartTV();
        
        t.switchON();
        t.changeChannel();
    }
}

// Example #2

class Car {
    public void start(){System.out.println("Car Started");}
    public void accelerate(){System.out.println("Car is Accelerated");}
    public void changeGear(){System.out.println("Car Gear Changed");}
    
}

class LuxaryCar extends Car {
    public void changeGear(){System.out.println("Automatic Gear");}
    public void openRoof(){System.out.println("Sun Roof is Opened");}
    
}

public class OverrideExample {

    public static void main(String[] args) 
    {
        LuxaryCar c=new LuxaryCar();

        c.start();
        c.accelerate();
        c.changeGear();
        c.openRoof();
    }
}