package baekjoon.bruteForce1.boj10819;

import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.util.Arrays.*;

public class Main {
    private static int[] a;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        sort(a);

        int ans = 0;
        do {
            ans = max(ans, calc());
        } while (nextPermutation());

        System.out.println(ans);
    }

    private static int calc() {
        int sum = 0;
        for (int i = 1; i < n; i++)
            sum += abs(a[i - 1] - a[i]);
        return sum;
    }

    private static boolean nextPermutation() {
        int i = n - 1;
        while (i > 0 && a[i - 1] >= a[i])
            i -= 1;
        if (i <= 0)
            return false;

        int j = n - 1;
        while (a[j] <= a[i - 1])
            j -= 1;

        swap(i - 1, j);

        j = n - 1;
        while (i < j) {
            swap(i, j);
            i += 1;
            j -= 1;
        }

        return true;
    }

    private static void swap(int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
