package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Exercises for array challenges
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] array1 = readIntegers(5);
        System.out.println(findMin(array1));

        int[] array2 = {1, 2, 3, 4, 5};
        reverseFaster(array2);

    }

    /**
     * Mutate an array and reverse it
     * O(n/2) - runtime
     * @param array
     */
    private static void reverseFaster(int[] array) {
        System.out.println("Array = " + Arrays.toString(array));
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;
        for (int i=0; i<halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }

        System.out.println("Reversed array = " + Arrays.toString(array));
    }

    /**
     * Reverse an array by mutating the values
     * O(n) - runtime
     * Note. This is a form of mutation and you should probably return temp in real code
     * @param array int[] array to be reversed
     */
    public static void reverse(int[] array) {
        int[] temp = new int[array.length];
        int count = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            temp[count] = array[i];
            count++;
        }
        System.arraycopy(temp, 0, array, 0, temp.length);
    }

    /**
     * Determines the min of an array
     * @param array int[] array to find the min of
     * @return int -- min value in array
     */
    public static int findMin(int[] array) {
        int currentMin = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] < currentMin) {
                currentMin = array[i];
            }
        }
        return currentMin;
    }


    /**
     * Sorts an array in descending order
     * @param array int[] -- the array to be sorted
     * @return a sorted int[]
     *
     * Note. This is an O(n^2) runtime meaning it's slow as shit and u should definitely use
     * bucket sort instead
     */
    public static int[] descendingSort(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        int temp = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            for(int j = i+1; j < sortedArray.length; j++ ) {
                temp = sortedArray[i];
                sortedArray[i] = sortedArray[j];
                sortedArray[j] = temp;
            }
        }
        printArray(sortedArray);
        return sortedArray;
    }

    public static void printArray(int[] array) {
        for (int i=0; i<array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static int[] readIntegers(int count) {
        System.out.println("Enter " + count + " integer values.\r");
        int[] values = new int[count];

        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        return values;
    }
}
