package baekjoon.dataStructure1.practice.boj17413;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine() + "\n";
        Stack<Character> stack = new Stack<>();

        boolean flag = false;

        for (char ch : str.toCharArray()) {
            if (ch == '<') {
                flag = true;
                clearStack(bw, stack);
            }

            if (flag) {
                bw.write(ch);
            } else {
                if (ch == ' ') {
                    clearStack(bw, stack);
                    bw.write(' ');
                } else if (ch == '\n') {
                    clearStack(bw, stack);
                } else {
                    stack.push(ch);
                }
            }

            if (ch == '>') {
                flag = false;
            }
        }

        bw.flush();
    }

    private static void clearStack(BufferedWriter bw, Stack<Character> stack) throws IOException {
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
    }
}
