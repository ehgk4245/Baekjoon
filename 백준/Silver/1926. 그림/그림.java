import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph = new int[500][500];
    static boolean[][] visit = new boolean[500][500];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int maxSize;
    static int count;

    static class Cordinate {

        private final int x;
        private final int y;

        Cordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visit[i][j]) {
                    count++;
                    int size = bfs(i, j, n, m);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        bw.write(count + "\n" + maxSize);

        bw.flush();
        br.close();
        bw.close();
    }

    static int bfs(int x, int y, int n, int m) {
        Queue<Cordinate> queue = new ArrayDeque<>();
        queue.add(new Cordinate(x, y));
        visit[x][y] = true;
        int size = 1;

        while (!queue.isEmpty()) {
            Cordinate cordinate = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cordinate.x + dx[i];
                int ny = cordinate.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (graph[nx][ny] != 1 || visit[nx][ny]) continue;
                queue.add(new Cordinate(nx, ny));
                visit[nx][ny] = true;
                size += 1;
            }
        }

        return size;
    }
}