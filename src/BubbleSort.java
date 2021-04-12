import utils.BaseSort;
import utils.SortDataCheck;
import utils.SwapUtils;

public class BubbleSort implements BaseSort {
    public static void main(String[] args) {
        SortDataCheck sortDataCheck = new SortDataCheck();
        sortDataCheck.check(new SelectionSort());
    }

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    SwapUtils.swap(arr, j, j + 1);
                }
            }
        }
    }
}
