import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main { //최솟값 : bfs

    public static class Emoticon {

        private int screen;
        private int clip;

        public Emoticon(int screen, int clip) {
            this.screen = screen;
            this.clip = clip;
        }

        public int getScreen() {
            return screen;
        }

        public int getClip() {
            return clip;
        }
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());

        int result = bfs(s);
        System.out.println(result);

    }

    private static int bfs(int s) {
        boolean visit[][] = new boolean[2000][1001]; //현재 화면 , 클립보드

        Queue<Emoticon> queue = new LinkedList<>();
        queue.add(new Emoticon(1, 0)); //현재 화면 개수, 클립보드 개수

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(); // 1
            for (int i = 0; i < size; i++) {
                Emoticon emoticon = queue.poll();
                int screenEmoticon = emoticon.getScreen();
                int clipboardEmoticon = emoticon.getClip(); // 화면에 저장된 이모티콘 개수가 동일한 경우 최초 경우
                if (screenEmoticon == s) {
                    return count;
                }

                // 클립보드에서 복사해서 붙이기(붙여넣기 하면 클립보드에 있는 이모티콘의 개수가 화면에 추가된다)
                if (screenEmoticon < s && !visit[screenEmoticon + clipboardEmoticon][clipboardEmoticon]) {
                    visit[screenEmoticon + clipboardEmoticon][clipboardEmoticon] = true;
                    queue.add(new Emoticon(screenEmoticon + clipboardEmoticon, clipboardEmoticon));
                }

                if (screenEmoticon > 0) {
                    // 화면에서 한개 지우기
                    if (!visit[screenEmoticon - 1][clipboardEmoticon]) {
                        visit[screenEmoticon - 1][clipboardEmoticon] = true;
                        queue.add(new Emoticon(screenEmoticon - 1, clipboardEmoticon));
                    }

                    // 화면에서 클립보드로 복사하기 (클립보드에 복사하면 이전의 클립보드 내용 위에 덮어쓰기가 된다)
                    if (screenEmoticon < s && !visit[screenEmoticon][screenEmoticon]) {
                        visit[screenEmoticon][screenEmoticon] = true;
                        queue.add(new Emoticon(screenEmoticon, screenEmoticon));
                    }
                }
            }
            count++;
        }
        return count;
    }
}
