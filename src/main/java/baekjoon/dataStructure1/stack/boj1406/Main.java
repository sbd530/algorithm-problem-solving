package baekjoon.dataStructure1.stack.boj1406;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        var sb = new StringBuilder();

        var leftStack = new Stack<>();
        var rightStack = new Stack<>();

        var word = br.readLine();
        var M = Integer.parseInt(br.readLine());

        for (var ch : word.toCharArray())
            leftStack.push(ch);

        while (M-- > 0) {
            var exe = br.readLine();

            if (exe.equals("L")) {
                if (!leftStack.isEmpty())
                    rightStack.push(leftStack.pop());
            }
            else if (exe.equals("D")) {
                if (!rightStack.isEmpty())
                    leftStack.push(rightStack.pop());
            }
            else if (exe.equals("B")) {
                if (!leftStack.isEmpty())
                    leftStack.pop();
            }
            else if (exe.startsWith("P")) {
                var addingStr = exe.substring(2);
                leftStack.push(addingStr);
            }
        }

        while (!leftStack.isEmpty())
            rightStack.push(leftStack.pop());

        while (!rightStack.isEmpty())
            sb.append(rightStack.pop());

        bw.write(sb.toString());
        bw.flush();
    }
}
