package baekjoon.bfs.boj1679;

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

        // Start from [n]
        visit[n] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int cur = q.remove();

            if (cur - 1 >= MIN_VALUE) {
                if (!visit[cur - 1]) {
                    q.add(cur - 1);
                    visit[cur - 1] = true;
                    distance[cur - 1] = distance[cur] + 1;
                }
            }

            if (cur + 1 < MAX_VALUE) {
                if (!visit[cur + 1]) {
                    q.add(cur + 1);
                    visit[cur + 1] = true;
                    distance[cur + 1] = distance[cur] + 1;
                }
            }

            if (cur * 2 < MAX_VALUE) {
                if (!visit[cur * 2]) {
                    q.add(cur * 2);
                    visit[cur * 2] = true;
                    distance[cur * 2] = distance[cur] + 1;
                }
            }
        }

        System.out.println(distance[k]);
    }
}