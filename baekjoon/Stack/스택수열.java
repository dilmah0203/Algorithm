package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class 스택수열 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int start = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine()); //8

            if (num > start) {
                for (int j = start + 1; j <= num; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                start = num;
            } else if (stack.peek() != num) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);
    }
}
