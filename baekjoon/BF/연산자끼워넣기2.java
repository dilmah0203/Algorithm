package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기2 {


    public static int n;
    public static int[] array;
    public static int[] operator;
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, array[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int sum) {
        if (depth == n) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] == 0) {
                continue;
            }
            operator[i]--;
            switch (i) {
                case 0:
                    dfs(depth + 1, sum + array[depth]);
                    break;
                case 1:
                    dfs(depth + 1, sum - array[depth]);
                    break;
                case 2:
                    dfs(depth + 1, sum * array[depth]);
                    break;
                case 3:
                    dfs(depth + 1, sum / array[depth]);
                    break;
            }
            operator[i]++;
        }
    }
}
