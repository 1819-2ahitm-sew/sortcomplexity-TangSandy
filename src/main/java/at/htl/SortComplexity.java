package at.htl;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SortComplexity {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int numberOfArraysToSort = 0;
        int sizeOfArray = 0;

        System.out.print("Anzahl der zu sortierenden Arrays: ");
        numberOfArraysToSort = scanner.nextInt();

        System.out.print("Größe der Arrays: ");
        sizeOfArray = scanner.nextInt();

        ArrayList<Long> arrayList = new ArrayList<>();
        long help = 0;
        long averageTime = 0;

        for (int i = 1; i < numberOfArraysToSort + 1; i++) {
            long ms = sortRandomArray(sizeOfArray);
            System.out.println("Laufzeit zur Sortierung des " + i + ". Arrays: " + ms + " ms");
            arrayList.add(i -1, ms);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            help = help + arrayList.get(i);
        }

        averageTime = help / arrayList.size();

        System.out.println("");
        System.out.println("Durschnittliche Laufzeit: " +  averageTime + " ms");

    }

    // Sorts an array of random numbers and returns the sorting run time in ms
    public static long sortRandomArray(int length) {
        int[] array = generateRandomArray(length);
        System.currentTimeMillis();
        sort(array);
        System.currentTimeMillis();



        return System.currentTimeMillis();

    }

    // Returns an array of random numbers
    public static int[] generateRandomArray(int length) {
        Random r = new Random();
        int low = 0;
        int high = 1000;
        int[] randomArray = new int[length];
        int result;

        for (int i = 0; i < length; i++) {
            result = r.nextInt(high - low) + low;
            randomArray[i] = result;
        }

        return randomArray;
    }

    // Sorts an array of numbers in ascending order
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    swap(array, i, j);
                }
            }

        }

    }

    // Swaps the array elements with index i and j
    public static void swap(int[] array, int i, int j) {
        int help = array[j];
        array[j] = array[i];
        array[i] = help;
    }
}
