public class LinearSearch {

    public static void main(String[] args) {
        int[] a = {3,5,1,7,8,4,9};

        int index = linearSearch(a, 4);

        if (index != -1) {
            System.out.println("Element found at: " + index);
        } else {
            System.out.println("Element not found");
        }
    }

    private static int linearSearch(int[] a, int value) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == value) {
                return i;
            }
        }
        return -1;
    }
}