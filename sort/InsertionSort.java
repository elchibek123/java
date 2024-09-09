public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 6, 1, 4, 7, 9, 2};

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }

        System.out.println("Sorted array:");
        for (int x : array) {
            System.out.print(x + " ");
        }
    }
}