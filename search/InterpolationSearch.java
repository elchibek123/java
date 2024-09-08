import java.util.Arrays;

public class InterpolationSearch {

    public static void main(String[] args) {

        int[] array = {5, 2, 6, 1, 4, 7, 9, 2};

        Arrays.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));

        int index = interpolationSearch(array, 4);

        if (index != -1) {
            System.out.println("Element found at: " + index);
        } else {
            System.out.println("Element not found");
        }
    }

    private static int interpolationSearch(int[] array, int value) {

        int high = array.length - 1;
        int low = 0;

        while (value >= array[low] && value <= array[high] && low <= high) {
            
            int probe = low + (high - low) * (value - array[low]) / (array[high] - array[low]);

            System.out.println("probe: " + probe);

            if (array[probe] == value) {
                return probe;
            } else if (array[probe] < value) {
                low = probe + 1;
            } else {
                high = probe - 1;
            }
        }

        return -1;
    }
}