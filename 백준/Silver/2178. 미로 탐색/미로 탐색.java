import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[][] graph = new int[101][101];
    static final boolean[][] visit = new boolean[101][101];
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    static class Cordinate {
        int x;
        int y;
        int distance;

        Cordinate(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                graph[i][j] = s.charAt(j - 1) - '0';
            }
        }

        Queue<Cordinate> queue = new ArrayDeque<>();
        queue.add(new Cordinate(1, 1, 1));
        visit[1][1] = true;
        int distance = 0;

        while (!queue.isEmpty()) {
            Cordinate cordinate = queue.poll();
            distance = Math.max(distance, cordinate.distance);
            if (cordinate.x == n && cordinate.y == m) break;
            for (int i = 0; i < 4; i++) {
                int nx = cordinate.x + dx[i];
                int ny = cordinate.y + dy[i];
                int nd = cordinate.distance + 1;
                if (nx > n || ny > m) continue;
                if (graph[nx][ny] != 1 || visit[nx][ny]) continue;
                queue.add(new Cordinate(nx, ny, nd));
                visit[nx][ny] = true;
            }
        }

        bw.write(String.valueOf(distance));

        bw.flush();
        br.close();
        bw.close();
    }
}