import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<?>> map = new HashMap<>(); // LinkedHashMap - print in order // TreeMap - sorts key in map
        map.put("cars", new ArrayList<>(Arrays.asList("bmw", "audi", "toyota")));
        map.put("John Doe", new ArrayList<>(Arrays.asList(773789873, 312432443, 34342235)));

        System.out.println(map.get("cars"));

        Set<Map.Entry<String, List<?>>> entries = map.entrySet();

        for (Map.Entry<String, List<?>> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
