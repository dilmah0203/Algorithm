package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 열쇠 {

    static int t, h, w, key;
    static int max;
    static char[][] array;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            key = 0; //key에 대한 정보
            max = 0; //문서의 최대 개수
            array = new char[102][102]; //빌딩의 밖에 있고, 가장자리 벽이 아닌 곳을 통해 빌딩을 드나들어야 하기 때문
            visited = new int[102][102];

            for (int i = 0; i <= h + 1; i++) {
                for (int j = 0; j <= w + 1; j++) {
                    visited[i][j] = -1;
                }
            }

            for (int i = 1; i <= h; i++) {
                String s = br.readLine();
                for (int j = 1; j <= w; j++) {
                    array[i][j] = s.charAt(j - 1);
                }
            }

            String keyInput = br.readLine(); // 만약 keyInput이 "rc"일 경우 'r'과 'c' 두 문자를 처리하여 key 비트를 업데이트
            if (!keyInput.equals("0")) {
                char[] c = keyInput.toCharArray();
                for (int i = 0; i < c.length; i++) {
                    // 만약 keys가 acde일 경우 key 변수의 비트 중 첫번째, 두번째, 세번째 비트가 1로 설정 0000 0000... 0001 1101
                    key |= (1 << c[i] - 97); // int로 충분히 알파벳 26개의 비트를 표현 가능하다.
                }
            }

            bfs();
            System.out.println(max);
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        visited[0][0] = key; //빌딩의 밖에서 출발
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx < 0 || cx >= h + 2 || cy < 0 || cy >= w + 2 || array[cx][cy] == '*'
                    || visited[cx][cy] == key) { //벽이 아닌 곳을 통해 빌딩 밖과 안을 드나들 수 있다.
                    continue;
                }

                visited[cx][cy] = key;
                if (array[cx][cy] >= 'A' && array[cx][cy] <= 'Z') { // 문을 만나면 해당 알파벳으로 표시된 문을 열기 위한 열쇠가
                    if ((key & (1 << array[cx][cy] - 65)) == 0) { // key 변수에 있는지 확인
                        continue; // 없으면 continue를 통해 다음 반복 진행
                    }
                } else if (array[cx][cy] >= 'a' && array[cx][cy] <= 'z') {
                    key |= (1 << (array[cx][cy] - 97)); // 열쇠라면 key 변수에 추가
                } else if (array[cx][cy] == '$') { // 문서라면
                    max++;
                }

                array[cx][cy] = '.'; // 지나온 경로를 표시하기 위해 빈 공간으로 바꾼다. 열쇠는 여러 번 사용할 수 있기 때문에 한 번 연 곳은 빈칸 처리
                queue.add(new int[]{cx, cy});
            }
        }
    }
}
