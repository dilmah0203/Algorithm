package DFS;

class 카카오프렌즈컬러링북 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int size;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    size = 0;
                    dfs(i, j, m, n, picture);
                    numberOfArea++;

                    if (size > maxSizeOfOneArea) {
                        maxSizeOfOneArea = size;
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }


    static void dfs(int x, int y, int m, int n, int[][] picture) {
        visited[x][y] = true;
        size++;
        for (int i = 0; i < 4; i++) {
            int cx = y + dx[i];
            int cy = x + dy[i];

            if (0 > cy || cy >= m || 0 > cx || cx >= n || visited[cy][cx]) {
                continue;
            }

            if (picture[x][y] == picture[cy][cx]) {
                dfs(cy, cx, m, n, picture);
            }
        }
    }
}

