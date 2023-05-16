package impl;

import util.Partition;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    /**
     * Do not modify this method.
     */
    public static void main(String[] args) {
        int[] sortedArray = readAndSort("numbers.txt");
        System.out.println(Arrays.toString(sortedArray));
    }

    /**
     * Reads an array of integers from a given resource file using FileInput.readIntsFromFile and sorts the resulting
     * array using multithreaded QuickSort provided by QuicksortRunnable.
     *
     * @param filePath Path to the file containing the integer array.
     * @return Sorted array of integers.
     */
    public static int[] readAndSort(String filePath) {
        // reading file
        var integers = FileInput.readIntsFromFile(filePath);

        // empty case
        if(integers.length == 0) return integers; // [ ]

        // defining sorting entities
        var partition = new Partition(integers, 0, integers.length);
        var quickSort = new QuicksortRunnable(partition);
        var runnableQuickSort = new Thread(quickSort);

        // sorting in parallel
        runnableQuickSort.start();

        // returning
        return integers;
    }
}
