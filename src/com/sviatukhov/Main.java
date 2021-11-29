package com.sviatukhov;

import java.util.Arrays;
import java.util.Random;

public class Main {
    /*
2*) Реализовать метод который сортирует массив целых чисел быстрой сортировкой.
Можно найти готовую реализацию и разобраться или написать свою:
https://en.wikipedia.org/wiki/Quicksort   */

    public static final int COUNT = 10;

    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < COUNT; i++) {
            array[i] = random.nextInt(50);
        }
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int low, int high) {
        int middle = low + (high - low) / 2;
        int supportElement = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < supportElement) {
                i++;
            }

            while (array[j] > supportElement) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

}