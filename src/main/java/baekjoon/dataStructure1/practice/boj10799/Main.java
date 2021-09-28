package baekjoon.dataStructure1.practice.boj10799;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String bar = br.readLine();
        int length = bar.length();
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < length; i++) {
            if (bar.charAt(i) == '(') {
                stack.push(i);
            } else {
                // ')'
                if (stack.peek() + 1 == i) {
                    // 앞 문자가 '('인 경우
                    stack.pop();
                    count += stack.size();
                } else {
                    // 앞 문자가 ')'인 경우
                    stack.pop();
                    count += 1;
                }
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();
    }
}
