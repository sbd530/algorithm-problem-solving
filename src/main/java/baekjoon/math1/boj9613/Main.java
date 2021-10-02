package baekjoon.math1.boj9613;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(temp[i+1]);

            long sum = 0;
            for (int i = 0; i < n-1; i++)
                for (int j = i+1; j < n; j++)
                    sum += getGCD(nums[i], nums[j]);

            bw.write(sum + "\n");
        }

        bw.flush();
    }

    private static int getGCD(int x, int y) {
        if (y == 0)
            return x;
        else
            return getGCD(y, x % y);
    }
}
