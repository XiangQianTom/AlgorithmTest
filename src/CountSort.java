import utils.BaseSort;
import utils.SortDataCheck;

public class CountSort implements BaseSort {

    private static final int BOUND = 10;

    public static void main(String[] args) {
        SortDataCheck.getChecker().updateArrChildBound(BOUND).check(10, new CountSort());
    }

    @Override
    public void sort(int[] arr) {
//        sort1(arr);
        int[] count = new int[BOUND];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        int[] arrayCopy = new int[arr.length];
        System.arraycopy(arr, 0, arrayCopy, 0, arr.length);
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[--count[arrayCopy[i]]] = arrayCopy[i];
        }
    }

    private void sort1(int[] arr) {
        int[] count = new int[BOUND];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }
}
