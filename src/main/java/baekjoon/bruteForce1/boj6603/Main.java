package baekjoon.bruteForce1.boj6603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static int[] a;
    private static int[] d;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            n = sc.nextInt();
            if (n == 0) break;
            a = new int[n];
            d = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (i < n - 6)
                    d[i] = 0;
                else
                    d[i] = 1;
            }

            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            do {
                ArrayList<Integer> cur = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (d[i] == 1)
                        cur.add(a[i]);
                }
                ans.add(cur);
            } while (nextPermutation());

            ans.sort((list1, list2) -> {
                int i = 0;
                while (i < list1.size() && i < list2.size()) {
                    if (list1.get(i) < list2.get(i))
                        return -1;
                    else if (list1.get(i) > list2.get(i))
                        return 1;
                    i += 1;
                }
                if (i == list1.size() && i != list2.size())
                    return -1;
                else if (i != list1.size() && i == list2.size())
                    return 1;
                return 0;
            });
            ans.forEach(list -> {
                list.forEach(x -> sb.append(x).append(" "));
                sb.append("\n");
            });
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean nextPermutation() {
        int i = n - 1;
        while (i > 0 && d[i - 1] >= d[i])
            i -= 1;
        if (i <= 0)
            return false;

        int j = n - 1;
        while (d[j] <= d[i - 1])
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
        int temp = d[x];
        d[x] = d[y];
        d[y] = temp;
    }
}
