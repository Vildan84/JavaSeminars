package org.example;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args){
        int[] arr = {5, 4, 1, 9, 8, 7, 5, 6, 19, 8, 0};
        int size = arr.length;
        Sort(arr, size);
        System.out.println(Arrays.toString(arr));

    }

    public static void Sort(int[] array, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, n - mid);
//        System.out.println(Arrays.toString(array));

        Sort(left, mid);
        Sort(right, n - mid);

        merge(array, left, right, mid, n - mid);
    }

    public static void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                k++; i++;
            }
            else {
                arr[k] = rightArr[j];
                k++; j++;
            }
        }
        while (i < left) {
            arr[k] = leftArr[i];
            k++; i++;
        }
        while (j < right) {
            arr[k] = rightArr[j];
            k++; j++;
        }
    }
}
