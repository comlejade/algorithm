package sample;

public class Practice {
    private Practice() {}

    public static void selectionSort(int[] source) {
        for (int i = 0; i < source.length; i++) {
            int minIndex = i;
            for (int j = i; j < source.length; j++) {
                if (source[j] < source[minIndex]) {
                    minIndex = j;
                }
            }
            swap(source, minIndex, i);
        }
    }

    public static void insertionSort(int[] source) {
        for (int i = 0; i < source.length; i++) {
            int tmp = source[i];
            int j = i;
            for (; j - 1 >= 0; j--) {
                if (tmp < source[j - 1]) {
                    source[j] = source[j-1];
                } else {
                    break;
                }
            }
            source[j] = tmp;
        }
    }

    private static void swap(int[] source, int i, int j) {
        int tmp = source[i];
        source[i] = source[j];
        source[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,6,3,2,4,9,8,7};
//        Practice.selectionSort(arr);
        Practice.insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
