import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};
    static final Queue<Cordinate> queue = new ArrayDeque<>();
    static int n;
    static int m;

    static class Cordinate {
        int y;
        int x;
        int day;

        Cordinate(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    queue.add(new Cordinate(i, j, 0));
                }
            }
        }

        int day = 0;

        while (!queue.isEmpty()) {
            Cordinate cordinate = queue.poll();
            day = Math.max(day, cordinate.day);
            for (int i = 0; i < 4; i++) {
                int ny = cordinate.y + dy[i];
                int nx = cordinate.x + dx[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (graph[ny][nx] == 1 || graph[ny][nx] == -1) continue;
                graph[ny][nx] = 1;
                queue.add(new Cordinate(ny, nx, cordinate.day + 1));
            }
        }

        boolean success = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) success = false;
            }
        }

        if (success) {
            bw.write(String.valueOf(day));
        } else {
            bw.write("-1");
        }

        bw.flush();
        br.close();
        bw.close();
    }

}