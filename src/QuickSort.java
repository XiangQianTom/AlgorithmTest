import utils.BaseSort;
import utils.SortDataCheck;

/**
 * 快速排序
 * 任选一个值作为基准元素（通常选取第一个），然后将比它小的排到它的位置之前，
 * 将比它大的排到它的位置之后，这样就完成了一趟快排（或一次划分）。然后以基准元素左右再次进行快排，最终完成排序。
 */
public class QuickSort implements BaseSort {
    public static void main(String[] args) {
        SortDataCheck.getChecker().check(4, new QuickSort());
    }

    @Override
    public void sort(int[] arr) {
//        sort(arr, 0, arr.length - 1);
//        sort1(arr, 0, arr.length - 1);
        sort2(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {//方法一，左边为轴
        if (left >= right) {
            return;
        }
        int i = left, j = right, temp = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= temp) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] < temp) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[j] = temp;
        sort(arr, left, i - 1);
        sort(arr, j + 1, right);
    }

    private void sort1(int[] arr, int left, int right) {//方法二，右边为轴
        if (left >= right) {
            return;
        }
        int i = left, j = right, temp = arr[right];
        while (i < j) {
            while (i < j && arr[i] <= temp) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
            while (i < j && arr[j] > temp) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
        }
        arr[j] = temp;
        sort1(arr, left, i - 1);
        sort1(arr, j + 1, right);
    }

    private void sort2(int[] arr, int left, int right) {//方法三，左边为轴
        if (left >= right) {
            return;
        }
        int i = left, j = right, temp = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= temp) j--;
            arr[i] = arr[j];
            while (i < j && arr[i] < temp) i++;
            arr[j] = arr[i];
        }
        arr[i] = temp;
        sort2(arr, left, i - 1);
        sort2(arr, i + 1, right);
    }
}
