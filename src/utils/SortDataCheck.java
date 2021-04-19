package utils;

import org.omg.CORBA.IRObject;

import java.util.Arrays;
import java.util.Random;

public class SortDataCheck {

    public static SortDataCheck getChecker() {
        return new SortDataCheck();
    }

    public void check(BaseSort sort) {
        check(-1, 10000, sort);
    }

    public void check(int arrSize, BaseSort sort) {
        check(arrSize, 10000, sort);
    }

    public void check(int arrSize, int testSize, BaseSort sort) {
        boolean check = true;
        for (int i = 0; i < testSize; i++) {
            int size = getArrSize(arrSize);
            int[] originalArr = getRandomArr(size);
            int[] selfSortArr = new int[size];
            int[] systemSortArr = new int[size];
            check = copyArrAndCheck(size, sort, originalArr, selfSortArr, systemSortArr);
            if (!check) {
                printOriginalSelfSoft(i, size, originalArr, selfSortArr);
                System.out.println("系统排序：");
                PrintUtils.printArr(systemSortArr);
                break;
            } else {
                printOriginalSelfSoft(i, size, originalArr, selfSortArr);
            }
        }
        if (check) {
            System.out.println("排序方法正确");
        }
    }

    private void printOriginalSelfSoft(int i, int size, int[] originalArr, int[] selfSortArr) {
        System.out.println("测试第" + i + "次，数组长度：" + size + " 原始数组：");
        PrintUtils.printArr(originalArr);
        System.out.println("自己排序：");
        PrintUtils.printArr(selfSortArr);
    }

    private int getArrSize(int arrSize) {
        Random random = new Random();
        if (arrSize < 0) {
            return 20;
        }
        return random.nextInt(arrSize) + 2;
    }

    private boolean copyArrAndCheck(int arrSize, BaseSort sort, int[] originalArr, int[] selfSortArr, int[] systemSortArr) {
        boolean check;
        System.arraycopy(originalArr, 0, selfSortArr, 0, arrSize);
        System.arraycopy(originalArr, 0, systemSortArr, 0, arrSize);
        sort.sort(selfSortArr);
        Arrays.sort(systemSortArr);
        check = check(selfSortArr, systemSortArr);
        return check;
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
