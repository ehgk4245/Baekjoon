import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    static class Cordinate {
        int y;
        int x;

        public Cordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] graph = new int[N][M];
            Queue<Cordinate> queue = new ArrayDeque<>();

            int count = 0;
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int colIndex = Integer.parseInt(st.nextToken());
                int rowIndex = Integer.parseInt(st.nextToken());
                graph[rowIndex][colIndex] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 1) {
                        queue.add(new Cordinate(i, j));
                        graph[i][j] = 2;
                        bfs(queue, graph);
                        count++;
                    }
                }
            }
            bw.write(count + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(Queue<Cordinate> queue, int[][] graph) {
        while (!queue.isEmpty()) {
            Cordinate cordinate = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cordinate.x + dx[i];
                int ny = cordinate.y + dy[i];

                if (ny < 0 || ny >= graph.length || nx < 0 || nx >= graph[0].length) continue;
                if (graph[ny][nx] == 2 || graph[ny][nx] == 0) continue;
                queue.add(new Cordinate(ny, nx));
                graph[ny][nx] = 2;
            }
        }
    }
}