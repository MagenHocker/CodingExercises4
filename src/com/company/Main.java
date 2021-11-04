package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Exercises for array challenges
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {

        boolean flag = true;
        printInstructions();
        while (flag) {

            System.out.println("\n Enter your command: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    flag = false;
                    break;
            }
        }



        int[] array1 = readIntegers(5);
        System.out.println(findMin(array1));

        int[] array2 = {1, 2, 3, 4, 5};
        reverseFaster(array2);


    }

    public static void findContact() {
        System.out.println("Name of contact you want to find: ");
        String name = scanner.nextLine();
        if (mobilePhone.hasContact(name) >= 0) {
            System.out.println("Contact found at position " + (mobilePhone.hasContact(name) + 1) );
        } else {
            System.out.println("Contact not found");
        }
    }

    public static void updateContact() {
        System.out.println("Name of contact you want to update: ");
        String name = scanner.nextLine();
        System.out.println("New name? ");
        String updatedName = scanner.nextLine();
        System.out.println("New Number? ");
        int number = scanner.nextInt();
        scanner.nextLine();
        mobilePhone.updateContact(name, updatedName, number);
    }

    public static void removeContact() {
        System.out.println("Name of contact you want to remove? ");
        String name = scanner.nextLine();
        mobilePhone.removeContact(name);
    }

    public static void addContact() {
        System.out.println("Name of contact? ");
        String name = scanner.nextLine();
        System.out.println("Number of contact? ");
        int number = scanner.nextInt();
        scanner.nextLine();
        mobilePhone.addContact(name, number);
    }

    public static void printContacts() {
        mobilePhone.printContacts();
    }


    public static void printInstructions() {
        System.out.println("\nYou have options: ");
        System.out.println("\t 0 - review instruction guide");
        System.out.println("\t 1 - print a list of contacts");
        System.out.println("\t 2 - Add a contact");
        System.out.println("\t 3 - Delete a contact");
        System.out.println("\t 4 - Update an existing contact");
        System.out.println("\t 5 - Find Contact");
        System.out.println("\t 6 - Quit");
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
