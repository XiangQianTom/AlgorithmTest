import utils.BaseSort;
import utils.SortDataCheck;

public class MergeSort implements BaseSort {
    public static void main(String[] args) {
        SortDataCheck dataCheck = new SortDataCheck();
        dataCheck.check(new MergeSort());
    }

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 选取中间点，开头点，末尾点，从中间点右边开始与开始点位置比较，将较小的存储在临时数组中，若中间点一边使用完毕，另一边直接添加到末尾
     * @param arr
     * @param left
     * @param right
     */
    private void sort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + ((right - left) >> 1);
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid + 1, right);
    }

    private void merge(int[] arr, int left, int right, int rightBound) {
        if (left >= right) return;
        int i = left, j = right, k = 0;
        int[] temp = new int[rightBound - left + 1];
        while (i < right && j <= rightBound) temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        while (i < right) temp[k++] = arr[i++];
        while (j <= rightBound) temp[k++] = arr[j++];
        for (int m = 0; m < temp.length; m++) arr[left + m] = temp[m];
    }
}
