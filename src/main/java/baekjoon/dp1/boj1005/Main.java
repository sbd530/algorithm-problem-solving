package baekjoon.dp1.boj1005;

import java.util.*;

public class Main {
    // DP 캐시, 건축 시간
    private static int[] cache, time;
    // 해당 건물의 선행필요 건물 정보
    private static HashMap<Integer, ArrayList<Integer>> cond;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            cache = new int[n + 1];
            // 탐색 여부 false 를 -1로 설정
            for (int i = 1; i <= n; i++)
                cache[i] = -1;
            time = new int[n + 1];
            cond = new HashMap<>();
            for (int i = 1; i <= n; i++)
                time[i] = sc.nextInt();
            for (int i = 1; i <= k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (cond.containsKey(y))
                    cond.get(y).add(x);
                else
                    cond.put(y, new ArrayList<>(Collections.singletonList(x)));
            }
            int w = sc.nextInt();

            // 우승 조건 건물부터 앞쪽으로 탐색 시작
            int ans = dfs(w);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    private static int dfs(int cur) {
        // escape 설정
        if (!cond.containsKey(cur))
            return time[cur];
        if (cache[cur] != -1)
            return cache[cur];
        // 초기화
        cache[cur] = 0;
        // [해당 건물 완료 시간] = max(모든 선행 건물 완료 시간들) + [해당 건물 건축 시간]
        var preBuildList = cond.get(cur);
        int max = 0;
        for (int pre : preBuildList)
            max = Math.max(max, dfs(pre));

        return max + time[cur];
    }
}