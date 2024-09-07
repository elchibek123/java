import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        DynamicArray dynamicArray = new DynamicArray(5);

        dynamicArray.add("firstItem");
        dynamicArray.add("secondItem");
        dynamicArray.add("thirdItem");

        dynamicArray.insert(1, "newItem");
        dynamicArray.insert(3, "secondNewItem");
        dynamicArray.insert(4, "thirdNewItem");

        dynamicArray.delete("firstItem");
        dynamicArray.delete("secondItem");
        dynamicArray.delete("thirdItem");

        dynamicArray.search("thirdItem");

        System.out.println("index: " + dynamicArray.search("thirdItem"));
        System.out.println(dynamicArray);
        System.out.println("empty: " + dynamicArray.isEmpty());
        System.out.println("size: " + dynamicArray.size);
        System.out.println("capacity: " + dynamicArray.capacity);
    }
}