import utils.BaseSort;
import utils.SortDataCheck;

public class QuickSort implements BaseSort {
    public static void main(String[] args) {
        SortDataCheck.getChecker().check(500, new QuickSort());
    }

    @Override
    public void sort(int[] arr) {
//        sort(arr, 0, arr.length - 1);
        sort1(arr, 0, arr.length - 1);
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
}
