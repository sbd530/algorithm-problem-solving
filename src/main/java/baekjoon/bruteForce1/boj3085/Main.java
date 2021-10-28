package baekjoon.bruteForce1.boj3085;

import java.util.Scanner;

public class Main {

    private static char[][] a;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new char[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next().toCharArray();
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    swap(i, j, i, j + 1);
                    max = Math.max(max, countMax());
                    swap(i, j, i, j + 1);
                }

                if (i + 1 < n) {
                    swap(i, j, i + 1, j);
                    max = Math.max(max, countMax());
                    swap(i, j, i + 1, j);
                }
            }
        }

        System.out.println(max);
    }

    private static int countMax() {
        int max = 1;
        for (int k = 0; k < n; k++) {
            int count = 1;
            for (int l = 1; l < n; l++) {
                if (a[k][l] == a[k][l - 1]) count += 1;
                else count = 1;
                max = Math.max(max, count);
            }

            count = 1;
            for (int l = 1; l < n; l++) {
                if (a[l][k] == a[l - 1][k]) count += 1;
                else count = 1;
                max = Math.max(max, count);
            }
        }
        return max;
    }

    private static void swap(int i, int j, int di, int dj) {
        char temp = a[i][j];
        a[i][j] = a[di][dj];
        a[di][dj] = temp;
    }

}
