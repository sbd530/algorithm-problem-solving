package baekjoon.bruteForce1.boj2309;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ONE_HUNDRED = 100;
        int sum = 0;
        int[] a = new int[9];
        for (int i = 0; i < 9; i++){
            a[i] = sc.nextInt();
            sum += a[i];
        }

        Arrays.sort(a);
        for (int i = 0; i < 8; i++)
            for (int j = i + 1; j < 9; j++)
                if (sum - a[i] - a[j] == ONE_HUNDRED) {
                    for (int k = 0; k < 9; k++)
                        if (k != i && k != j)
                            System.out.println(a[k]);
                    System.exit(0);
                }
    }
}
