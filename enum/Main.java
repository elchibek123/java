import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            switch (Region.valueOf(new Scanner(System.in).nextLine().toUpperCase())) {
                case Region.BATKEN -> System.out.println(Region.BATKEN.getUniqueInfo());
                case Region.OSH -> System.out.println(Region.BATKEN.getUniqueInfo());
                case Region.JALAL_ABAD -> System.out.println(Region.BATKEN.getUniqueInfo());
                case Region.TALAS -> System.out.println(Region.BATKEN.getUniqueInfo());
                case Region.CHUI -> System.out.println(Region.BATKEN.getUniqueInfo());
                case Region.YSSYK_KOL -> System.out.println(Region.BATKEN.getUniqueInfo());
                case Region.NARYN -> System.out.println(Region.BATKEN.getUniqueInfo());
                default -> System.err.println("Invalid region name");
            }
        }
    }
}
