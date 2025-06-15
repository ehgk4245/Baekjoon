import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    static class Cordinate {
        int y;
        int x;
        char color;

        public Cordinate(int y, int x, char color) {
            this.y = y;
            this.x = x;
            this.color = color;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        boolean[][] visit1 = new boolean[n][n];
        boolean[][] visit2 = new boolean[n][n];
        char[][] monitor = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                monitor[i][j] = s.charAt(j);
            }
        }

        int count1 = count(n, visit1, monitor);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (monitor[i][j] == 'G') monitor[i][j] = 'R';
            }
        }

        int count2 = count(n,visit2, monitor);

        bw.write(count1 + " " + count2);

        bw.flush();
        br.close();
        bw.close();
    }

    private static int count(int n, boolean[][] visit, char[][] monitor) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    Queue<Cordinate> queue = new ArrayDeque<>();
                    queue.add(new Cordinate(i, j, monitor[i][j]));
                    visit[i][j] = true;
                    bfs(queue, monitor, visit);
                    count++;
                }
            }
        }
        return count;
    }


    static void bfs(Queue<Cordinate> queue, char[][] monitor, boolean[][] visit) {
        while (!queue.isEmpty()) {
            Cordinate cordinate = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cordinate.y + dy[i];
                int nx = cordinate.x + dx[i];
                char color = cordinate.color;
                if (ny < 0 || ny >= monitor.length || nx < 0 || nx >= monitor[0].length) continue;
                if (monitor[ny][nx] != color || visit[ny][nx]) continue;
                queue.add(new Cordinate(ny, nx, color));
                visit[ny][nx] = true;
            }
        }
    }
}