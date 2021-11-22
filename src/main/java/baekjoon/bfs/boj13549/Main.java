package baekjoon.bfs.boj13549;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    private static final int MAX_VALUE = 100_001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] check = new boolean[MAX_VALUE];
        int[] dist = new int[MAX_VALUE];
        check[n] = true;
        dist[n] = 0;

        Deque<Integer> q = new ArrayDeque<>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.pollFirst();
            int[] nextArray = {now * 2, now - 1, now + 1};
            for (int next : nextArray) {
                if (0 <= next && next < MAX_VALUE) {
                    if (!check[next]) {
                        check[next] = true;
                        if (next == now * 2) {
                            q.addFirst(next);
                            dist[next] = dist[now];
                        } else {
                            q.addLast(next);
                            dist[next] = dist[now] + 1;
                        }
                    }
                }
            }
        }

        System.out.println(dist[m]);
    }
}
