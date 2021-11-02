package baekjoon.bruteForce1.boj10971;

import java.util.Scanner;

import static java.lang.Math.min;

public class Main {
    private static int n;
    private static int[] a;
    private static int[][] w;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        w = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                w[i][j] = sc.nextInt();
            a[i] = i;
        }

        int ans = Integer.MAX_VALUE;
        do {
            int sum = calc();
            ans = min(ans, sum);
        } while (nextPermutation());

        System.out.println(ans);
    }

    private static int calc() {
        boolean ok = true;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            if (w[a[i]][a[i + 1]] == 0)
                ok = false;
            else
                sum += w[a[i]][a[i + 1]];
        }
        if (ok && w[a[n - 1]][a[0]] != 0) {
            sum += w[a[n - 1]][a[0]];
            return sum;
        }
        return Integer.MAX_VALUE;
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
