import utils.BaseSort;
import utils.SortDataCheck;
import utils.SwapUtils;

public class ShellSort implements BaseSort {
    public static void main(String[] args) {
        SortDataCheck sortDataCheck = new SortDataCheck();
        sortDataCheck.check(new ShellSort());
    }

    @Override
    public void sort(int[] arr) {
        int gape = 1;
        while (gape <= arr.length / 3) {
            gape = 3 * gape + 1;
        }
        for (; gape > 0; gape = (gape - 1) / 3) {
            for (int i = gape; i < arr.length; i++) {
                for (int j = i; j > gape - 1; j -= gape) {
                    if (arr[j] < arr[j - gape]) {
                        SwapUtils.swap(arr, j, j - gape);
                    }
                }
            }
        }
    }
}
