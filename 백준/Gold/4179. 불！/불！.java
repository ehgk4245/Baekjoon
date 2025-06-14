import java.io.*;
import java.util.*;

public class Main {

    static final char[][] graph = new char[1001][1001];
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};
    static final Deque<Cordinate> deque = new ArrayDeque<>();

    static class Cordinate {
        int y;
        int x;
        int dist;

        Cordinate(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = s.charAt(j);
                if (graph[i][j] == 'F') deque.addFirst(new Cordinate(i, j, -1));
                if (graph[i][j] == 'J') deque.addLast(new Cordinate(i, j, 0));
            }
        }

        boolean possible = false;
        int result = 0;

        outer :
        while (!deque.isEmpty()) {
            Cordinate cordinate = deque.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cordinate.y + dy[i];
                int nx = cordinate.x + dx[i];
                if (cordinate.dist != -1 && (ny == R || nx == C || ny == -1 || nx == -1)) {
                    possible = true;
                    result = cordinate.dist + 1;
                    break outer;
                }
                if (cordinate.dist == -1) {
                    if (ny >= R || nx >= C || ny < 0 || nx < 0) continue;
                    if (graph[ny][nx] == '#' || graph[ny][nx] == 'F') continue;
                    graph[ny][nx] = 'F';
                    deque.add(new Cordinate(ny, nx, -1));
                } else {
                    if (graph[ny][nx] == '#' || graph[ny][nx] == 'F' || graph[ny][nx] == 'j') continue;
                    graph[ny][nx] = 'j';
                    deque.add(new Cordinate(ny, nx, cordinate.dist + 1));
                }
            }
        }

        if (possible) {
            bw.write(String.valueOf(result));
        } else {
            bw.write("IMPOSSIBLE");
        }

        bw.flush();
        br.close();
        bw.close();
    }

}