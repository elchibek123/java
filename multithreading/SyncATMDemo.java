class ATM {
    synchronized public void checkBalance(String name) {
        System.out.println(name + " is checking");
        try {Thread.sleep(100);} catch (InterruptedException e) {}
        System.out.println("balance");
    }

    synchronized public void withdraw(String name, int amount) {
        System.out.println(name + " is withdrawing");
        try {Thread.sleep(100);} catch (InterruptedException e) {}
        System.out.println(amount);
    }
}

class Customer extends Thread {
    ATM atm;
    String name;
    int amount;

    public Customer(ATM atm, String name, int amount) {
        this.atm = atm;
        this.name = name;
        this.amount = amount;
    }

    public void useATM() {
        atm.checkBalance(name);
        atm.withdraw(name, amount);
    }

    public void run() {
        useATM();
    }
}

public class SyncATMDemo {
    public static void main(String[] args) {
        ATM atm = new ATM();

        Customer c1 = new Customer(atm,"John", 45);
        Customer c2 = new Customer(atm,"Smith", 3);
        Customer c3 = new Customer(atm,"David", 54);

        c1.start();
        c2.start();
        c3.start();
    }
}