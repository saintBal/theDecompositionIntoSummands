package ru.levelp.theDecompositionIntoSummands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 Разложение на слагаемые (рекурсия, массивы):

  Пользователь вводит натуральное число N
  Надо вывести все разложения на слагаемые. Разложения отличающиеся порядком слагаемых считаются одинаковыми.
 +```
  N = 4
  4 = 4
  4 = 3 + 1
  4 = 2 + 2
  4 = 2 + 1 + 1
  4 = 1 + 1 + 1 + 1
 +```
  N <= 100
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Можно вводить число до 550.\nПосле у меня начинает работать Garbage collection.");
        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n];
        int l = 1;
        arr[0] = n;

        printSplit(arr, n);
        do {
            l = next_back(arr, l, n);
            printSplit(arr, l);
        } while (l < n);

    }


    private static int next_back(int[] arr, int l, int n) {
        int i = l;
        do {
            i--;
        } while (i > 0 && arr[i] <= 1);
        arr[i]--;

        int sum = 0;
        int c = 0;
        while (arr[c] > 0)
            sum += arr[c++];

        int value = arr[i];
        do
            i++;
        while (arr[i] >= value);
        if (arr[i] == 0) c++;
        arr[i]++;

        return c;
    }

    private static void printSplit(int[] arr, int l) {
        for (int i = 0; i < l; i++) {
            if (arr[i] == 0) break;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
