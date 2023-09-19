package chap02;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        int[] arr1 = {3, 5, 2};
        int[] arr2 = arr1;
        arr2[1] = 0;
        System.out.println("Shallow Copy");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));

        arr1[1] = 5;
        int[] arr3 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        arr3[1] = 0;
        System.out.println("Deep Copy");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr3: " + Arrays.toString(arr3));
    }
}