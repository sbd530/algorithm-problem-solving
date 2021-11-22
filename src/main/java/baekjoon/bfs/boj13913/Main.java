package baekjoon.bfs.boj13913;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final int MAX_VALUE = 100_001;
    private static final int MIN_VALUE = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[] visit = new boolean[MAX_VALUE];
        int[] distance = new int[MAX_VALUE];
        int[] from = new int[MAX_VALUE];

        // Start from [n]
        visit[n] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int curr = q.remove();

            int next = curr - 1;
            if (next >= MIN_VALUE) {
                if (!visit[next]) {
                    q.add(next);
                    visit[next] = true;
                    distance[next] = distance[curr] + 1;
                    from[next] = curr;
                }
            }

            next = curr + 1;
            if (next < MAX_VALUE) {
                if (!visit[next]) {
                    q.add(next);
                    visit[next] = true;
                    distance[next] = distance[curr] + 1;
                    from[next] = curr;
                }
            }

            next = curr * 2;
            if (next < MAX_VALUE) {
                if (!visit[next]) {
                    q.add(next);
                    visit[next] = true;
                    distance[next] = distance[curr] + 1;
                    from[next] = curr;
                }
            }
        }

        System.out.println(distance[k]);
        print(from, n, k);
    }

    private static void print(int[] from, int n, int m) {
        if (n != m)
            print(from, n, from[m]);

        System.out.print(m + " ");
    }
}
