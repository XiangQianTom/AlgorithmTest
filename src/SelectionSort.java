import utils.BaseSort;
import utils.SortDataCheck;
import utils.SwapUtils;

public class SelectionSort implements BaseSort {
    /**
     * 选择排序：每循环一次后，查找到最小的值与当前值进行交互，一直遍历到最后
     * 时间复杂度：N^2
     * 空间复杂度：1
     *
     * @param args
     */
    public static void main(String[] args) {
        SortDataCheck sortDataCheck = new SortDataCheck();
        sortDataCheck.check(5, new SelectionSort());
    }

    @Override
    public void sort(int[] arr) {
        sort2(arr);
    }

    private static void sort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[minPos] > arr[j] ? j : minPos;
            }
            SwapUtils.swap(arr, i, minPos);
        }
    }

    private static void sort2(int[] arr) {
        for (int i = 0, k = arr.length - 1; i < k; i++, k--) {
            int minPos = i;
            int maxPos = k;
            for (int j = i + 1; j <= k; j++) {
                minPos = arr[minPos] > arr[j] ? j : minPos;
                maxPos = arr[maxPos] > arr[j] ? maxPos : j;
            }
            SwapUtils.swap(arr, i, minPos);
            maxPos = arr[maxPos] > arr[minPos] ? maxPos : minPos;
            SwapUtils.swap(arr, k, maxPos);
        }
    }
}
