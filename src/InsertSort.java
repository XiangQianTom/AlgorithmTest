import utils.BaseSort;
import utils.SortDataCheck;
import utils.SwapUtils;

public class InsertSort implements BaseSort {
    public static void main(String[] args) {
        SortDataCheck sortDataCheck = new SortDataCheck();
        sortDataCheck.check(new InsertSort());
//        InsertSort insertSort = new InsertSort();
//        insertSort.sort(new int[]{9874, 6152, 373});
    }

    @Override
    public void sort(int[] arr) {
//        sort1(arr);
        sort2(arr);
    }

    /**
     * 双层循环，临时保存当前值，判断当前值与内层循环每一个值大小，符合条件（大于或者小于）后，前面的值赋值给后面的值，依次平移，
     * 记录最后插入点，临时保存值赋值给最后插入点
     * @param arr
     */
    private void sort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tempIndex = i;
            int temp = arr[i];
            for (int j = i - 1; j >= 0 && arr[j] > temp; j--) {
                tempIndex = j;
                arr[j + 1] = arr[tempIndex];
            }
            arr[tempIndex] = temp;
        }
    }

    /**
     * 双层循环，内层循环判断当前与前一个大小进行交换
     *
     * @param arr
     */
    private void sort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                SwapUtils.swap(arr, j, j - 1);
            }
        }
    }
}
