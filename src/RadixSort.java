import utils.BaseSort;
import utils.SortDataCheck;
import utils.SwapUtils;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort implements BaseSort {
    public static void main(String[] args) {
        SortDataCheck.getChecker().check(new RadixSort());
    }

    /**
     * 从个位数到最高位，每一位进行从小到大进行计数排序
     *
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        int length = arr.length;
        if (length <= 0) {
            return;
        }
        for (int i = 1; i < length; i++) {
            if (arr[i] < arr[i - 1]) {
                SwapUtils.swap(arr, i, i - 1);
            }
        }
        int max = String.valueOf(arr[length - 1]).length();
        int[] temp = new int[length];
        int[] count = new int[10];
        for (int i = 0; i < max; i++) {
            int pow = (int) Math.pow(10, i);
            for (int j = 0; j < length; j++) {
                count[arr[j] / pow % 10]++;
            }
            for (int k = 1; k < count.length; k++) {
                count[k] = count[k] + count[k - 1];
            }
            System.arraycopy(arr, 0, temp, 0, length);
            for (int z = length - 1; z >= 0; z--) {
                int num = temp[z] / pow % 10;
                arr[--count[num]] = temp[z];
            }
            Arrays.fill(count, 0);
        }
    }
}
