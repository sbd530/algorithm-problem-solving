package baekjoon.dynamicProgramming1.boj2294;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        // DS
        int[] cache = new int[k + 1];
        // INIT
        for (int i = 1; i <= n; i++)
            if (a[i] <= k) // 주어지는 동전 최대값 10만은 k보다 크다.
                cache[a[i]] = 1;
        // LOOP
        for (int i = 1; i <= k; i++)
                for (int j = 1; j <= n; j++)
                    if (i - a[j] >= 1 && cache[i - a[j]] != 0)
                        if (cache[i] == 0)
                            cache[i] = cache[i - a[j]] + 1;
                        else
                            cache[i] = Math.min(cache[i], cache[i - a[j]] + 1);

        if (cache[k] == 0)
            System.out.println(-1);
        else
            System.out.println(cache[k]);
    }
}
