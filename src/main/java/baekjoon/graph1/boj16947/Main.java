package baekjoon.graph1.boj16947;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static ArrayList<ArrayList<Integer>> map;
    private static int[] visit;
    private static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            map.add(new ArrayList<>());
        visit = new int[n];
        distance = new int[n];
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            map.get(u).add(v);
            map.get(v).add(u);
        }

        search(0, -1);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (visit[i] == 2) {
                distance[i] = 0;
                q.add(i);
            } else {
                distance[i] = -1;
            }
        }

        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : map.get(x)) {
                if (distance[y] == -1) {
                    q.add(y);
                    distance[y] = distance[x] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(distance[i] + " ");
        }
    }

    private static int search(int x, int p) {
        // -2: found cycle and not included
        // -1: not found cycle
        // 0~n-1: found cycle and start index

        if (visit[x] == 1) return x;

        visit[x] = 1;

        for (int y : map.get(x)) {
            if (y == p) continue;

            int res = search(y, x);

            if (res == -2) return -2;

            if (res >= 0) {
                visit[x] = 2;
                if (x == res) return -2;
                else return res;
            }
        }

        return -1;
    }
}
