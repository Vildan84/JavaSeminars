package org.example;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args){

        int[] arr = {4, 24, 1, 9, 56, 0, 3, 33, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr){
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--){
            heap(arr, i, n);
        }
        for (int i = n - 1; i >=0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heap(arr, 0, i);
        }
    }

    public static void heap(int[] arr, int i, int n){
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int max = i;

        if (l < n && arr[l] > arr[max]){
            max = l;
        }
        if (r < n && arr[r] > arr[max]){
            max = r;
        }
        if (i != max){
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heap(arr, max, n);
        }
    }
}
