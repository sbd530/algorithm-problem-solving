package baekjoon.dataStructure1.practice.boj17298;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");

        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(temp[i]);

        int[] nges = new int[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for (int i = 1; i < n; i++) {
            if (stack.isEmpty())
                stack.push(i);

            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                nges[stack.pop()] = nums[i];

            stack.push(i);
        }

        while (!stack.isEmpty())
            nges[stack.pop()] = -1;

        for (int nge : nges)
            bw.write(nge + " ");
        bw.flush();
    }
}
