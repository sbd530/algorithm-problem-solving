package baekjoon.dynamicProgramming1.boj9251;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] a1 = sc.nextLine().toCharArray();
        char[] a2 = sc.nextLine().toCharArray();
        // DS
        int[][] d = new int[a1.length + 1][a2.length + 1];
        // LOOP
        for (int i = 1; i <= a1.length; i++)
            for (int j = 1; j <= a2.length; j++)
                if (a1[i - 1] == a2[j - 1])
                    d[i][j] = d[i - 1][j - 1] + 1;
                else
                    d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);

        System.out.println(d[a1.length][a2.length]);
    }
}
