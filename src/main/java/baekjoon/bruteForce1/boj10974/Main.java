package baekjoon.bruteForce1.boj10974;

import java.util.Scanner;

public class Main {
    private static int[] a;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = i + 1;

        do {
            for (int i = 0; i < n; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        } while (nextPermutation());
    }

    private static boolean nextPermutation() {
        // a[i-1] < a[i] 를 만족하는 가장 큰 i 를 찾는다
        int i = n - 1;
        while (i > 0 && a[i - 1] >= a[i])
            i -= 1;
        if (i <= 0)
            return false;

        // j>=i 이면서 a[j] > a[i-1] 를 만족하는 가장 큰 j 를 찾는다
        int j = n - 1;
        while (a[j] <= a[i - 1])
            j -= 1;

        // a[i-1] 과 a[j] 를 swap 한다
        swap(i - 1, j);

        // a[i] 부터 순열을 뒤집는다
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
