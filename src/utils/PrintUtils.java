package utils;

public class PrintUtils {
    public static void printArr(int[] arr) {
        if (arr == null || arr.length <= 0) return;
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.print(arr[arr.length - 1]);
        System.out.println();
    }
}
