package utils;

import java.util.Arrays;
import java.util.Random;

public class SortDataCheck {

    public void check(int arrSize, BaseSort sort) {
        check(arrSize, 10000, sort);
    }

    public void check(int arrSize, int testSize, BaseSort sort) {
        boolean check = true;
        for (int i = 0; i < testSize; i++) {
            int[] originalArr = getRandomArr(arrSize);
            int[] selfSortArr = new int[arrSize];
            int[] systemSortArr = new int[arrSize];
            System.arraycopy(originalArr, 0, selfSortArr, 0, arrSize);
            System.arraycopy(originalArr, 0, systemSortArr, 0, arrSize);
            sort.sort(selfSortArr);
            Arrays.sort(systemSortArr);
            check = check(selfSortArr, systemSortArr);
            if (!check) {
                System.out.println("测试第" + i + "次后失败，原始数组：");
                PrintUtils.printArr(originalArr);
                System.out.println("自己排序：");
                PrintUtils.printArr(selfSortArr);
                System.out.println("系统排序：");
                PrintUtils.printArr(systemSortArr);
                break;
            }
        }
        if (check) {
            System.out.println("排序方法正确");
        }
    }

    private boolean check(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        if (length1 != length2) {
            return false;
        }
        for (int i = 0; i < length1; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getRandomArr(int arrSize) {
        Random random = new Random();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }
}
